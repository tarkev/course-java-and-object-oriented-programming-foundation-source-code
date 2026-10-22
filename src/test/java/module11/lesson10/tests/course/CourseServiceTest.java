package module11.lesson10.tests.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import module11.lesson10.tests.course.storage.InMemoryCourseRepository;
import org.junit.jupiter.api.Test;

class CourseServiceTest {

    private final CourseService service =
            new CourseService(new InMemoryCourseRepository());
    private final CourseCode javaOop = new CourseCode("JAVA-OOP");

    @Test
    void unknownCourseIsReported() {
        CourseNotFoundException exception = assertThrows(
                CourseNotFoundException.class,
                () -> service.findCourse(new CourseCode("NOPE")));

        assertEquals("Course not found: NOPE.", exception.getMessage());
    }

    @Test
    void publishingWithoutLessonsKeepsTheCourseRule() {
        service.createCourse(javaOop, "Java and OOP Foundation", 499_000L);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> service.publishCourse(javaOop));

        assertEquals("Course must have at least one lesson before publication.",
                exception.getMessage());
        assertEquals(CourseStatus.DRAFT, service.findCourse(javaOop).status());
    }

}
