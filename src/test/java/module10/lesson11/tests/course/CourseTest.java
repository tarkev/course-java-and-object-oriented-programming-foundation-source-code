package module10.lesson11.tests.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseTest {

    private Course course;

    @BeforeEach
    void createDraftCourse() {
        course = new Course(
                new CourseCode("JAVA-OOP"), "Java and OOP Foundation", 499_000L);
    }

    @Test
    void changeTitleOnDraftStoresStrippedTitle() {
        course.changeTitle(" Advanced Java ");

        assertEquals("Advanced Java", course.getTitle());
    }

    @Test
    void publishedTitleCannotBeChanged() {
        course.publish();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> course.changeTitle("Advanced Java"));

        assertEquals("Published course title cannot be changed.",
                exception.getMessage());
        assertEquals("Java and OOP Foundation", course.getTitle());
    }

    @Test
    void threeCharacterTitleCanBePublished() {
        Course git = new Course(new CourseCode("GIT"), "Git", 0L);

        git.publish();

        assertEquals(CourseStatus.PUBLISHED, git.getStatus());
    }

    @Test
    void negativePriceIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course(new CourseCode("JAVA-OOP"), "Java", -1L));
    }
}
