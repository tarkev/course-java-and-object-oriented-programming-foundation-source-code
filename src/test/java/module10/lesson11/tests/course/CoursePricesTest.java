package module10.lesson11.tests.course;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class CoursePricesTest {

    @Test
    void totalIncludesEveryCourse() {
        List<Course> courses = List.of(
                new Course(new CourseCode("JAVA-OOP"), "Java and OOP", 100L),
                new Course(new CourseCode("BACKEND"), "Backend", 200L),
                new Course(new CourseCode("SPRING"), "Spring Boot", 300L));

        assertEquals(600L, CoursePrices.totalPriceInPaisa(courses));
    }
}
