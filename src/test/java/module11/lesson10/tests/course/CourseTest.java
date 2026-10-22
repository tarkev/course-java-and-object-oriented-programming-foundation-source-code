package module11.lesson10.tests.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CourseTest {

    private static final CourseCode JAVA_OOP = new CourseCode("JAVA-OOP");
    private static final Lesson INTRO =
            new Lesson(new LessonId(1L), "Introduction", "What Java is.");

    private Course course;

    @BeforeEach
    void createDraftCourse() {
        course = new Course(JAVA_OOP, "Java and OOP Foundation", 499_000L);
    }

    @Test
    void newCourseIsDraft() {
        assertEquals(CourseStatus.DRAFT, course.getStatus());
    }

    @Test
    void reusedLessonIdIsRejected() {
        course.addLesson(INTRO);
        Lesson sameId = new Lesson(new LessonId(1L), "Other", "Other text.");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> course.addLesson(sameId));

        assertEquals("Lesson id already exists: 1.", exception.getMessage());
        assertEquals(List.of(INTRO), course.getLessons());
    }

    @Test
    void publishedCourseCannotBePublishedAgain() {
        publishWithIntro();

        IllegalStateException exception =
                assertThrows(IllegalStateException.class, course::publish);

        assertEquals("Only draft courses can be published.",
                exception.getMessage());
    }

    @Test
    void draftCourseCannotBeArchived() {
        IllegalStateException exception =
                assertThrows(IllegalStateException.class, course::archive);

        assertEquals("Only published courses can be archived.",
                exception.getMessage());
        assertEquals(CourseStatus.DRAFT, course.getStatus());
    }

    @Test
    void archivedCourseCannotBeArchivedAgain() {
        publishWithIntro();
        course.archive();

        assertThrows(IllegalStateException.class, course::archive);
        assertEquals(CourseStatus.ARCHIVED, course.getStatus());
    }

    @Test
    void publishedCourseRejectsNewLessons() {
        publishWithIntro();
        Lesson next = new Lesson(new LessonId(2L), "Classes", "Objects.");

        IllegalStateException exception = assertThrows(
                IllegalStateException.class, () -> course.addLesson(next));

        assertEquals("Lessons can only be added to draft courses.",
                exception.getMessage());
    }

    @Test
    void publishedCourseTitleCannotChange() {
        publishWithIntro();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> course.changeTitle("New Title"));

        assertEquals("Only draft course title can be changed.",
                exception.getMessage());
        assertEquals("Java and OOP Foundation", course.getTitle());
    }

    @Test
    void lessonListCannotBeChangedFromOutside() {
        course.addLesson(INTRO);

        assertThrows(UnsupportedOperationException.class,
                () -> course.getLessons().clear());
    }

    @Test
    void restoreCopiesTheGivenLessonList() {
        List<Lesson> lessons = new ArrayList<>(List.of(INTRO));
        Course restored = Course.restore(JAVA_OOP, "Java and OOP Foundation",
                499_000L, CourseStatus.PUBLISHED, lessons);

        lessons.clear();

        assertEquals(List.of(INTRO), restored.getLessons());
    }

    @Test
    void restoredPublishedCourseNeedsALesson() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Course.restore(JAVA_OOP, "Java and OOP Foundation",
                        499_000L, CourseStatus.PUBLISHED, List.of()));

        assertEquals("Published course must contain at least one lesson.",
                exception.getMessage());
    }

    @Test
    void restoreRejectsDuplicateLessonIds() {
        Lesson sameId = new Lesson(new LessonId(1L), "Other", "Other text.");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Course.restore(JAVA_OOP, "Java and OOP Foundation",
                        499_000L, CourseStatus.DRAFT, List.of(INTRO, sameId)));

        assertEquals("Course contains duplicate lesson ids.",
                exception.getMessage());
    }

    private void publishWithIntro() {
        course.addLesson(INTRO);
        course.publish();
    }
}
