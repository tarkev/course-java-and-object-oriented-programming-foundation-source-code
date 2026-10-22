package module09.lesson07.example01.repository;

import module09.lesson07.example01.course.Course;
import module09.lesson07.example01.course.CourseCode;
import module09.lesson07.example01.course.CourseStatus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

public final class FileCourseRepository implements CourseRepository {

    private static final String EXTENSION = ".properties";

    private final Path baseDirectory;

    public FileCourseRepository(Path baseDirectory) {
        if (baseDirectory == null) {
            throw new IllegalArgumentException("Base directory is required.");
        }

        this.baseDirectory = baseDirectory.toAbsolutePath().normalize();
    }

    @Override
    public void save(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course is required.");
        }

        Path target = resolveFile(course.getCode());

        try {
            Files.createDirectories(baseDirectory);
            replaceFile(target, serialize(course));
        } catch (IOException exception) {
            throw new CourseRepositoryException(
                    "Could not save course " + course.getCode(), exception);
        }
    }

    @Override
    public Optional<Course> findByCode(CourseCode courseCode) {
        try {
            return Optional.of(loadCourse(resolveFile(courseCode)));
        } catch (NoSuchFileException exception) {
            return Optional.empty();
        } catch (IOException exception) {
            throw new CourseRepositoryException(
                    "Could not load course " + courseCode, exception);
        }
    }

    @Override
    public List<Course> findAll() {
        if (Files.notExists(baseDirectory)) {
            return List.of();
        }

        try (Stream<Path> paths = Files.list(baseDirectory)) {
            return paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(EXTENSION))
                    .map(this::loadListedCourse)
                    .toList();
        } catch (IOException exception) {
            throw new CourseRepositoryException(
                    "Could not list stored courses", exception);
        }
    }

    @Override
    public boolean deleteByCode(CourseCode courseCode) {
        try {
            return Files.deleteIfExists(resolveFile(courseCode));
        } catch (IOException exception) {
            throw new CourseRepositoryException(
                    "Could not delete course " + courseCode, exception);
        }
    }

    private Path resolveFile(CourseCode courseCode) {
        if (courseCode == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        String fileName = courseCode.value().toLowerCase(Locale.ROOT);
        Path target = baseDirectory.resolve(fileName + EXTENSION).normalize();

        if (!baseDirectory.equals(target.getParent())) {
            throw new IllegalArgumentException(
                    "Course path escapes repository directory.");
        }

        return target;
    }

    private Properties serialize(Course course) {
        Properties properties = new Properties();
        properties.setProperty("code", course.getCode().value());
        properties.setProperty("title", course.getTitle());
        properties.setProperty(
                "priceInPaisa", Long.toString(course.getPriceInPaisa()));
        properties.setProperty("status", course.getStatus().name());
        return properties;
    }

    private Course loadCourse(Path path) throws IOException {
        Properties properties = new Properties();

        try (BufferedReader reader =
                     Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            properties.load(reader);
        }

        try {
            return Course.restore(
                    new CourseCode(require(properties, "code")),
                    require(properties, "title"),
                    Long.parseLong(require(properties, "priceInPaisa")),
                    CourseStatus.valueOf(require(properties, "status")));
        } catch (RuntimeException exception) {
            throw new CourseRepositoryException(
                    "Stored course data is invalid: " + path.getFileName(),
                    exception);
        }
    }

    private String require(Properties properties, String key) {
        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing property: " + key);
        }

        return value;
    }

    private Course loadListedCourse(Path path) {
        try {
            return loadCourse(path);
        } catch (IOException exception) {
            throw new CourseRepositoryException(
                    "Could not load " + path.getFileName(), exception);
        }
    }

    private void replaceFile(Path target, Properties properties)
            throws IOException {
        Path temp = Files.createTempFile(baseDirectory, "course-", ".tmp");

        try {
            try (BufferedWriter writer =
                         Files.newBufferedWriter(temp, StandardCharsets.UTF_8)) {
                properties.store(writer, null);
            }

            moveIntoPlace(temp, target);
        } catch (IOException | RuntimeException exception) {
            try {
                Files.deleteIfExists(temp);
            } catch (IOException cleanupFailure) {
                exception.addSuppressed(cleanupFailure);
            }

            throw exception;
        }
    }

    private void moveIntoPlace(Path temp, Path target) throws IOException {
        try {
            Files.move(temp, target,
                    StandardCopyOption.ATOMIC_MOVE,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (AtomicMoveNotSupportedException exception) {
            Files.move(temp, target, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
