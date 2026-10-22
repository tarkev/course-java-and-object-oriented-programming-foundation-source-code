package module10.lesson02.example03.course;

import java.util.ArrayList;
import java.util.List;

public final class Course {

    private static final int MAX_LESSONS = 50;

    private final CourseCode code;
    private final List<Lesson> lessons;

    private String title;
    private CourseStatus status;

    public Course(CourseCode code, String title, List<Lesson> initialLessons) {
        if (code == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        if (initialLessons == null) {
            throw new IllegalArgumentException("Initial lessons are required.");
        }

        List<Lesson> copy = new ArrayList<>(initialLessons);

        if (copy.contains(null)) {
            throw new IllegalArgumentException("Lessons cannot contain null.");
        }

        if (copy.size() > MAX_LESSONS) {
            throw new IllegalArgumentException(
                    "Course cannot have more than " + MAX_LESSONS + " lessons.");
        }

        long uniqueIds = copy.stream().map(Lesson::id).distinct().count();

        if (uniqueIds != copy.size()) {
            throw new IllegalArgumentException(
                    "Initial lessons contain duplicate ids.");
        }

        this.code = code;
        this.title = requireTitle(title);
        this.status = CourseStatus.DRAFT;
        this.lessons = copy;
    }

    public void changeTitle(String newTitle) {
        if (status == CourseStatus.PUBLISHED) {
            throw new IllegalStateException(
                    "Published course title cannot be changed.");
        }

        title = requireTitle(newTitle);
    }

    public void addLesson(Lesson lesson) {
        if (lesson == null) {
            throw new IllegalArgumentException("Lesson is required.");
        }

        if (lessons.size() >= MAX_LESSONS) {
            throw new IllegalStateException(
                    "Course has reached the lesson limit.");
        }

        boolean duplicate = lessons.stream()
                .anyMatch(current -> current.id() == lesson.id());

        if (duplicate) {
            throw new IllegalArgumentException("Lesson id already exists.");
        }

        lessons.add(lesson);
    }

    public void publish() {
        if (lessons.isEmpty()) {
            throw new IllegalStateException(
                    "Course must have at least one lesson before publishing.");
        }

        status = CourseStatus.PUBLISHED;
    }

    public CourseCode getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public List<Lesson> getLessons() {
        return List.copyOf(lessons);
    }

    private static String requireTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        return title.strip();
    }
}
