package module11.lesson10.tests.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CourseCodeTest {

    @Test
    void codeIsStrippedAndUppercased() {
        assertEquals(new CourseCode("JAVA-OOP"), new CourseCode(" java-oop "));
    }

    @Test
    void blankCodeIsRejected() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new CourseCode(""));

        assertEquals("Course code is required.", exception.getMessage());
    }

    @Test
    void codeWithASpaceInsideIsRejected() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CourseCode("java oop"));

        assertEquals("Course code contains unsupported characters.",
                exception.getMessage());
    }
}
