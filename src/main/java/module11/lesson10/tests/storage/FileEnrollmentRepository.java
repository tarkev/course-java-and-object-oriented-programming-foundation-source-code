package module11.lesson10.tests.storage;

import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.enrollment.Enrollment;
import module11.lesson10.tests.enrollment.EnrollmentId;
import module11.lesson10.tests.enrollment.EnrollmentRepository;
import module11.lesson10.tests.enrollment.EnrollmentStatus;
import module11.lesson10.tests.learner.LearnerId;

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

public final class FileEnrollmentRepository implements EnrollmentRepository {

    private static final String EXTENSION = ".properties";

    private final Path baseDirectory;

    public FileEnrollmentRepository(Path baseDirectory) {
        if (baseDirectory == null) {
            throw new IllegalArgumentException(
                    "Enrollment storage directory is required.");
        }

        this.baseDirectory = baseDirectory.toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.baseDirectory);
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to initialize enrollment storage.", exception);
        }
    }

    @Override
    public void save(Enrollment enrollment) {
        if (enrollment == null) {
            throw new IllegalArgumentException("Enrollment is required.");
        }

        Properties properties = new Properties();
        properties.setProperty(
                "id", Long.toString(enrollment.getId().value()));
        properties.setProperty(
                "learnerId", Long.toString(enrollment.getLearnerId().value()));
        properties.setProperty(
                "courseCode", enrollment.getCourseCode().value());
        properties.setProperty("status", enrollment.getStatus().name());

        try {
            replaceFile(pathFor(enrollment.getId()), properties);
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to save enrollment " + enrollment.getId() + ".",
                    exception);
        }
    }

    @Override
    public Optional<Enrollment> findById(EnrollmentId enrollmentId) {
        if (enrollmentId == null) {
            throw new IllegalArgumentException("Enrollment id is required.");
        }

        try {
            return Optional.of(readEnrollment(pathFor(enrollmentId)));
        } catch (NoSuchFileException exception) {
            return Optional.empty();
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to read enrollment " + enrollmentId + ".", exception);
        }
    }

    @Override
    public boolean existsByLearnerAndCourse(
            LearnerId learnerId, CourseCode courseCode) {
        if (learnerId == null || courseCode == null) {
            throw new IllegalArgumentException(
                    "Learner id and course code are required.");
        }

        return findAll().stream()
                .anyMatch(enrollment ->
                        enrollment.getLearnerId().equals(learnerId)
                                && enrollment.getCourseCode().equals(courseCode));
    }

    @Override
    public List<Enrollment> findAll() {
        try (Stream<Path> paths = Files.list(baseDirectory)) {
            return paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(EXTENSION))
                    .sorted()
                    .map(this::readListedEnrollment)
                    .toList();
        } catch (IOException | UncheckedIOException exception) {
            throw new StorageException("Failed to list enrollments.", exception);
        }
    }

    private Enrollment readEnrollment(Path path) throws IOException {
        try {
            Properties properties = load(path);

            return Enrollment.restore(
                    new EnrollmentId(
                            Long.parseLong(required(properties, "id"))),
                    new LearnerId(
                            Long.parseLong(required(properties, "learnerId"))),
                    new CourseCode(required(properties, "courseCode")),
                    EnrollmentStatus.valueOf(required(properties, "status")));
        } catch (CharacterCodingException | IllegalArgumentException exception) {
            throw new StoredDataCorruptionException(
                    "Invalid enrollment data in " + path.getFileName() + ".",
                    exception);
        }
    }

    private Enrollment readListedEnrollment(Path path) {
        try {
            return readEnrollment(path);
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to read enrollment file " + path.getFileName() + ".",
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

    private Path pathFor(EnrollmentId enrollmentId) {
        return baseDirectory.resolve(enrollmentId.value() + EXTENSION);
    }

    private void replaceFile(Path target, Properties properties)
            throws IOException {
        Path temporary =
                Files.createTempFile(baseDirectory, "enrollment-", ".tmp");

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
