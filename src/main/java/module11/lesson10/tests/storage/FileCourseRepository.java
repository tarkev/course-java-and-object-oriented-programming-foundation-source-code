package module11.lesson10.tests.storage;

import module11.lesson10.tests.course.Course;
import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.course.CourseRepository;
import module11.lesson10.tests.course.CourseStatus;
import module11.lesson10.tests.course.Lesson;
import module11.lesson10.tests.course.LessonId;

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
import java.util.ArrayList;
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
            throw new IllegalArgumentException(
                    "Course storage directory is required.");
        }

        this.baseDirectory = baseDirectory.toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.baseDirectory);
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to initialize course storage.", exception);
        }
    }

    @Override
    public void save(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course is required.");
        }

        try {
            replaceFile(pathFor(course.getCode()), serialize(course));
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to save course " + course.getCode() + ".", exception);
        }
    }

    @Override
    public Optional<Course> findByCode(CourseCode courseCode) {
        if (courseCode == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        try {
            return Optional.of(readCourse(pathFor(courseCode)));
        } catch (NoSuchFileException exception) {
            return Optional.empty();
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to read course " + courseCode + ".", exception);
        }
    }

    @Override
    public List<Course> findAll() {
        try (Stream<Path> paths = Files.list(baseDirectory)) {
            return paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(EXTENSION))
                    .sorted()
                    .map(this::readListedCourse)
                    .toList();
        } catch (IOException | UncheckedIOException exception) {
            throw new StorageException("Failed to list courses.", exception);
        }
    }

    private Properties serialize(Course course) {
        Properties properties = new Properties();
        properties.setProperty("code", course.getCode().value());
        properties.setProperty("title", course.getTitle());
        properties.setProperty(
                "priceInPaisa", Long.toString(course.getPriceInPaisa()));
        properties.setProperty("status", course.getStatus().name());

        List<Lesson> lessons = course.getLessons();
        properties.setProperty("lesson.count", Integer.toString(lessons.size()));

        for (int index = 0; index < lessons.size(); index++) {
            Lesson lesson = lessons.get(index);
            String prefix = "lesson." + index + ".";
            properties.setProperty(
                    prefix + "id", Long.toString(lesson.id().value()));
            properties.setProperty(prefix + "title", lesson.title());
            properties.setProperty(prefix + "content", lesson.content());
        }

        return properties;
    }

    private Course readCourse(Path path) throws IOException {
        try {
            Properties properties = load(path);

            CourseCode code = new CourseCode(required(properties, "code"));
            String title = required(properties, "title");
            long price = Long.parseLong(required(properties, "priceInPaisa"));
            CourseStatus status =
                    CourseStatus.valueOf(required(properties, "status"));
            int lessonCount =
                    Integer.parseInt(required(properties, "lesson.count"));

            if (lessonCount < 0) {
                throw new IllegalArgumentException(
                        "Lesson count cannot be negative.");
            }

            List<Lesson> lessons = new ArrayList<>();

            for (int index = 0; index < lessonCount; index++) {
                String prefix = "lesson." + index + ".";
                LessonId id = new LessonId(
                        Long.parseLong(required(properties, prefix + "id")));
                lessons.add(new Lesson(id,
                        required(properties, prefix + "title"),
                        required(properties, prefix + "content")));
            }

            return Course.restore(code, title, price, status, lessons);
        } catch (CharacterCodingException | IllegalArgumentException exception) {
            throw new StoredDataCorruptionException(
                    "Invalid course data in " + path.getFileName() + ".",
                    exception);
        }
    }

    private Course readListedCourse(Path path) {
        try {
            return readCourse(path);
        } catch (IOException exception) {
            throw new StorageException(
                    "Failed to read course file " + path.getFileName() + ".",
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

    private Path pathFor(CourseCode courseCode) {
        String fileName = courseCode.value().toLowerCase(Locale.ROOT);
        Path path = baseDirectory.resolve(fileName + EXTENSION).normalize();

        if (!baseDirectory.equals(path.getParent())) {
            throw new IllegalArgumentException("Invalid course storage path.");
        }

        return path;
    }

    private void replaceFile(Path target, Properties properties)
            throws IOException {
        Path temporary = Files.createTempFile(baseDirectory, "course-", ".tmp");

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
