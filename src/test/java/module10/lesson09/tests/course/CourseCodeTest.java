package module10.lesson09.tests.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CourseCodeTest {

    @Test
    void stripsSpacesAndUppercasesTheValue() {
        CourseCode code = new CourseCode(" java-oop ");

        assertEquals("JAVA-OOP", code.value());
    }

    @Test
    void codesThatDifferOnlyInCaseAreEqual() {
        assertEquals(new CourseCode("JAVA-OOP"), new CourseCode("java-oop"));
    }

    @Test
    void rejectsBlankCode() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new CourseCode("   "));

        assertEquals("Course code is required.", exception.getMessage());
    }
}
