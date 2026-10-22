package module11.lesson10.tests.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import module11.lesson10.tests.course.Course;
import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.course.CourseStatus;
import module11.lesson10.tests.course.Lesson;
import module11.lesson10.tests.course.LessonId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class FileCourseRepositoryTest {

    private static final CourseCode JAVA_OOP = new CourseCode("JAVA-OOP");
    private static final String VALID_FILE = """
            code=JAVA-OOP
            title=Java and OOP Foundation
            priceInPaisa=499000
            status=DRAFT
            lesson.count=0
            """;

    @TempDir
    Path directory;

    @Test
    void specialCharactersLoadBackExactly() {
        Course course = new Course(JAVA_OOP, "জাভা # OOP = Java", 499_000L);
        course.addLesson(new Lesson(new LessonId(1L), "a = b",
                "Line one\nLine two # not a comment"));
        new FileCourseRepository(directory).save(course);

        Course loaded = new FileCourseRepository(directory)
                .findByCode(JAVA_OOP).orElseThrow();

        assertEquals(course.summary(), loaded.summary());
        assertEquals(course.getLessons(), loaded.getLessons());
    }

    @Test
    void savingAgainReplacesTheStoredCourse() {
        Course course = draftWithOneLesson();
        FileCourseRepository repository = new FileCourseRepository(directory);
        repository.save(course);
        course.publish();

        repository.save(course);

        Course loaded = new FileCourseRepository(directory)
                .findByCode(JAVA_OOP).orElseThrow();
        assertEquals(CourseStatus.PUBLISHED, loaded.getStatus());
    }

    @Test
    void saveLeavesNoTemporaryFile() throws IOException {
        FileCourseRepository repository = new FileCourseRepository(directory);

        repository.save(draftWithOneLesson());
        repository.save(draftWithOneLesson());

        try (Stream<Path> files = Files.list(directory)) {
            assertEquals(List.of("java-oop.properties"), files
                    .map(path -> path.getFileName().toString())
                    .toList());
        }
    }

    @Test
    void courseThatWasNeverSavedIsEmpty() {
        FileCourseRepository repository = new FileCourseRepository(directory);

        assertEquals(Optional.empty(), repository.findByCode(JAVA_OOP));
    }

    @Test
    void unknownStatusIsCorruptedData() throws IOException {
        writeJavaOopFile(VALID_FILE.replace("DRAFT", "NOT-A-STATUS"));
        FileCourseRepository repository = new FileCourseRepository(directory);

        StoredDataCorruptionException exception = assertThrows(
                StoredDataCorruptionException.class,
                () -> repository.findByCode(JAVA_OOP));

        assertEquals("Invalid course data in java-oop.properties.",
                exception.getMessage());
        assertInstanceOf(IllegalArgumentException.class, exception.getCause());
    }

    @Test
    void missingTitleIsCorruptedData() throws IOException {
        writeJavaOopFile(VALID_FILE.replace("title=Java and OOP Foundation\n",
                ""));
        FileCourseRepository repository = new FileCourseRepository(directory);

        assertThrows(StoredDataCorruptionException.class,
                () -> repository.findByCode(JAVA_OOP));
    }

    @Test
    void negativeLessonCountIsCorruptedData() throws IOException {
        writeJavaOopFile(VALID_FILE.replace("count=0", "count=-1"));
        FileCourseRepository repository = new FileCourseRepository(directory);

        assertThrows(StoredDataCorruptionException.class,
                () -> repository.findByCode(JAVA_OOP));
    }

    @Test
    void findAllFailsInsteadOfSkippingACorruptedFile() throws IOException {
        FileCourseRepository repository = new FileCourseRepository(directory);
        repository.save(draftWithOneLesson());
        Files.writeString(directory.resolve("broken.properties"),
                VALID_FILE.replace("DRAFT", "NOT-A-STATUS"));

        StoredDataCorruptionException exception = assertThrows(
                StoredDataCorruptionException.class, repository::findAll);

        assertEquals("Invalid course data in broken.properties.",
                exception.getMessage());
    }

    private Course draftWithOneLesson() {
        Course course = new Course(JAVA_OOP, "Java and OOP Foundation", 499_000L);
        course.addLesson(
                new Lesson(new LessonId(1L), "Introduction", "What Java is."));
        return course;
    }

    private void writeJavaOopFile(String content) throws IOException {
        Files.writeString(directory.resolve("java-oop.properties"), content);
    }
}
