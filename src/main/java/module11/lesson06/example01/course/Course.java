package module11.lesson06.example01.course;

import java.util.ArrayList;
import java.util.List;

public final class Course {

    private final CourseCode code;
    private final long priceInPaisa;
    private final List<Lesson> lessons;

    private String title;
    private CourseStatus status;

    public Course(CourseCode code, String title, long priceInPaisa) {
        this(code, title, priceInPaisa, CourseStatus.DRAFT, List.of());
    }

    private Course(CourseCode code, String title, long priceInPaisa,
            CourseStatus status, List<Lesson> lessons) {
        if (code == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (priceInPaisa < 0) {
            throw new IllegalArgumentException(
                    "Course price cannot be negative.");
        }

        if (status == null) {
            throw new IllegalArgumentException("Course status is required.");
        }

        if (lessons == null) {
            throw new IllegalArgumentException("Lessons are required.");
        }

        this.code = code;
        this.title = title.strip();
        this.priceInPaisa = priceInPaisa;
        this.status = status;
        this.lessons = new ArrayList<>(lessons);

        validateLessonIds();
        validateRestoredState();
    }

    public static Course restore(CourseCode code, String title,
            long priceInPaisa, CourseStatus status, List<Lesson> lessons) {
        return new Course(code, title, priceInPaisa, status, lessons);
    }

    public void changeTitle(String newTitle) {
        if (newTitle == null || newTitle.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (status != CourseStatus.DRAFT) {
            throw new IllegalStateException(
                    "Only draft course title can be changed.");
        }

        title = newTitle.strip();
    }

    public void addLesson(Lesson lesson) {
        if (lesson == null) {
            throw new IllegalArgumentException("Lesson is required.");
        }

        if (status != CourseStatus.DRAFT) {
            throw new IllegalStateException(
                    "Lessons can only be added to draft courses.");
        }

        if (containsLesson(lesson.id())) {
            throw new IllegalArgumentException(
                    "Lesson id already exists: " + lesson.id() + ".");
        }

        lessons.add(lesson);
    }

    public void publish() {
        if (status != CourseStatus.DRAFT) {
            throw new IllegalStateException(
                    "Only draft courses can be published.");
        }

        if (lessons.isEmpty()) {
            throw new IllegalStateException(
                    "Course must have at least one lesson before publication.");
        }

        status = CourseStatus.PUBLISHED;
    }

    public void archive() {
        if (status != CourseStatus.PUBLISHED) {
            throw new IllegalStateException(
                    "Only published courses can be archived.");
        }

        status = CourseStatus.ARCHIVED;
    }

    public boolean isPublished() {
        return status == CourseStatus.PUBLISHED;
    }

    public boolean isArchived() {
        return status == CourseStatus.ARCHIVED;
    }

    public boolean containsLesson(LessonId lessonId) {
        if (lessonId == null) {
            throw new IllegalArgumentException("Lesson id is required.");
        }

        return lessons.stream()
                .anyMatch(lesson -> lesson.id().equals(lessonId));
    }

    public CourseSummary summary() {
        return new CourseSummary(
                code, title, priceInPaisa, status, lessons.size());
    }

    public CourseCode getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public long getPriceInPaisa() {
        return priceInPaisa;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public List<Lesson> getLessons() {
        return List.copyOf(lessons);
    }

    private void validateLessonIds() {
        long uniqueIds = lessons.stream().map(Lesson::id).distinct().count();

        if (uniqueIds != lessons.size()) {
            throw new IllegalArgumentException(
                    "Course contains duplicate lesson ids.");
        }
    }

    private void validateRestoredState() {
        if (status == CourseStatus.PUBLISHED && lessons.isEmpty()) {
            throw new IllegalArgumentException(
                    "Published course must contain at least one lesson.");
        }
    }
}
