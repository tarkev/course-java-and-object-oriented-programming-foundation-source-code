package module10.lesson11.tests.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CourseCodeTest {

    @Test
    void uppercasesLowercaseCode() {
        assertEquals("BACKEND", new CourseCode("backend").value());
    }

    @Test
    void equalCodesHaveTheSameHashCode() {
        assertEquals(new CourseCode("JAVA-OOP").hashCode(),
                new CourseCode(" java-oop ").hashCode());
    }

    @Test
    void rejectsNullCode() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new CourseCode(null));

        assertEquals("Course code is required.", exception.getMessage());
    }

    @Test
    void rejectsCodeWithInnerSpace() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new CourseCode("JAVA OOP"));

        assertEquals("Course code contains unsupported characters.",
                exception.getMessage());
    }
}
