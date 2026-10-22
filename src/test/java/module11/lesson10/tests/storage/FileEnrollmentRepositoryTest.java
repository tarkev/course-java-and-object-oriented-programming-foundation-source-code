package module11.lesson10.tests.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.enrollment.Enrollment;
import module11.lesson10.tests.enrollment.EnrollmentId;
import module11.lesson10.tests.learner.LearnerId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileEnrollmentRepositoryTest {

    private static final EnrollmentId FIRST = new EnrollmentId(1001L);
    private static final LearnerId SAKIB = new LearnerId(1L);
    private static final CourseCode JAVA_OOP = new CourseCode("JAVA-OOP");

    @TempDir
    Path directory;

    @Test
    void completedEnrollmentSurvivesARestart() {
        Enrollment enrollment = new Enrollment(FIRST, SAKIB, JAVA_OOP);
        enrollment.complete();
        new FileEnrollmentRepository(directory).save(enrollment);

        Enrollment loaded = new FileEnrollmentRepository(directory)
                .findById(FIRST).orElseThrow();

        assertEquals(enrollment.summary(), loaded.summary());
    }

    @Test
    void storedEnrollmentIsFoundByLearnerAndCourse() {
        new FileEnrollmentRepository(directory)
                .save(new Enrollment(FIRST, SAKIB, JAVA_OOP));

        boolean exists = new FileEnrollmentRepository(directory)
                .existsByLearnerAndCourse(SAKIB, new CourseCode("java-oop"));

        assertTrue(exists);
    }

    @Test
    void nonNumericLearnerIdIsCorruptedData() throws IOException {
        Files.writeString(directory.resolve("1001.properties"),
                "id=1001\nlearnerId=abc\ncourseCode=JAVA-OOP\nstatus=ACTIVE\n");
        FileEnrollmentRepository repository =
                new FileEnrollmentRepository(directory);

        StoredDataCorruptionException exception = assertThrows(
                StoredDataCorruptionException.class,
                () -> repository.findById(FIRST));

        assertEquals("Invalid enrollment data in 1001.properties.",
                exception.getMessage());
        assertInstanceOf(NumberFormatException.class, exception.getCause());
    }
}
