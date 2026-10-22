package module10.lesson09.tests.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CourseTest {

    private Course course;

    @BeforeEach
    void createDraftCourse() {
        course = new Course(
                new CourseCode("JAVA-OOP"), "Java and OOP Foundation", 499_000L);
    }

    @Test
    void publishMovesDraftToPublished() {
        course.publish();

        assertEquals(CourseStatus.PUBLISHED, course.getStatus());
    }

    @Test
    @DisplayName("A published course cannot be published again")
    void publishTwiceIsRejected() {
        course.publish();

        IllegalStateException exception =
                assertThrows(IllegalStateException.class, course::publish);

        assertEquals("Course is already published.", exception.getMessage());
    }

    @Test
    void shortTitleBlocksPublication() {
        Course shortTitle = new Course(new CourseCode("GO"), "Go", 0L);

        assertThrows(IllegalStateException.class, shortTitle::publish);
        assertEquals(CourseStatus.DRAFT, shortTitle.getStatus());
    }
}
