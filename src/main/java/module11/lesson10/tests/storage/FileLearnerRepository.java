package module11.lesson10.tests.storage;

import module11.lesson10.tests.learner.EmailAddress;
import module11.lesson10.tests.learner.Learner;
import module11.lesson10.tests.learner.LearnerId;
import module11.lesson10.tests.learner.LearnerRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

public final class FileLearnerRepository implements LearnerRepository {

    private static final String EXTENSION = ".properties";

    private final Path baseDirectory;

    public FileLearnerRepository(Path baseDirectory) {
        if (baseDirectory == null) {
            throw new IllegalArgumentException(
                    "Learner storage directory is required.");
        }

        this.baseDirectory = baseDirectory.toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.baseDirectory);
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to initialize learner storage.", exception);
        }
    }

    @Override
    public void save(Learner learner) {
        if (learner == null) {
            throw new IllegalArgumentException("Learner is required.");
        }

        Properties properties = new Properties();
        properties.setProperty("id", Long.toString(learner.id().value()));
        properties.setProperty("name", learner.name());
        properties.setProperty("email", learner.email().value());

        try {
            replaceFile(pathFor(learner.id()), properties);
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to save learner " + learner.id() + ".", exception);
        }
    }

    @Override
    public Optional<Learner> findById(LearnerId learnerId) {
        if (learnerId == null) {
            throw new IllegalArgumentException("Learner id is required.");
        }

        try {
            return Optional.of(readLearner(pathFor(learnerId)));
        } catch (NoSuchFileException exception) {
            return Optional.empty();
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to read learner " + learnerId + ".", exception);
        }
    }

    @Override
    public Optional<Learner> findByEmail(EmailAddress email) {
        if (email == null) {
            throw new IllegalArgumentException("Email is required.");
        }

        return findAll().stream()
                .filter(learner -> learner.email().equals(email))
                .findFirst();
    }

    @Override
    public List<Learner> findAll() {
        try (Stream<Path> paths = Files.list(baseDirectory)) {
            return paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(EXTENSION))
                    .sorted()
                    .map(this::readListedLearner)
                    .toList();
        } catch (IOException | UncheckedIOException exception) {
            throw new StorageException("Failed to list learners.", exception);
        }
    }

    private Learner readLearner(Path path) throws IOException {
        try {
            Properties properties = load(path);

            return new Learner(
                    new LearnerId(Long.parseLong(required(properties, "id"))),
                    required(properties, "name"),
                    new EmailAddress(required(properties, "email")));
        } catch (CharacterCodingException | IllegalArgumentException exception) {
            throw new StoredDataCorruptionException(
                    "Invalid learner data in " + path.getFileName() + ".",
                    exception);
        }
    }

    private Learner readListedLearner(Path path) {
        try {
            return readLearner(path);
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to read learner file " + path.getFileName() + ".",
                    exception);
        }
    }

    private Properties load(Path path) throws IOException {
        Properties properties = new Properties();

        try (BufferedReader reader =
                     Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            properties.load(reader);
        }

        return properties;
    }

    private String required(Properties properties, String key) {
        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing property: " + key + ".");
        }

        return value;
    }

    private Path pathFor(LearnerId learnerId) {
        return baseDirectory.resolve(learnerId.value() + EXTENSION);
    }

    private void replaceFile(Path target, Properties properties)
            throws IOException {
        Path temporary = Files.createTempFile(baseDirectory, "learner-", ".tmp");

        try {
            try (BufferedWriter writer =
                         Files.newBufferedWriter(temporary, StandardCharsets.UTF_8)) {
                properties.store(writer, null);
            }

            moveIntoPlace(temporary, target);
        } catch (IOException | RuntimeException exception) {
            try {
                Files.deleteIfExists(temporary);
            } catch (IOException cleanupFailure) {
                exception.addSuppressed(cleanupFailure);
            }

            throw exception;
        }
    }

    private void moveIntoPlace(Path temporary, Path target) throws IOException {
        try {
            Files.move(temporary, target,
                    StandardCopyOption.ATOMIC_MOVE,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (AtomicMoveNotSupportedException exception) {
            Files.move(temporary, target, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
