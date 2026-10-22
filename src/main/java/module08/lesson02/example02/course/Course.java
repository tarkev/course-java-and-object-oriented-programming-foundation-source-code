package module08.lesson02.example02.course;

import java.util.ArrayList;
import java.util.List;

public final class Course {

    private final String title;
    private final List<String> lessons = new ArrayList<>();
    private CourseStatus status = CourseStatus.DRAFT;

    public Course(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        this.title = title.strip();
    }

    public void addLesson(String lessonTitle) {
        if (!status.isEditable()) {
            throw new IllegalStateException(
                    "Lessons cannot be changed while course status is "
                    + status.name() + ".");
        }

        if (lessonTitle == null || lessonTitle.isBlank()) {
            throw new IllegalArgumentException("Lesson title is required.");
        }

        lessons.add(lessonTitle.strip());
    }

    public void submitForReview() {
        if (status != CourseStatus.DRAFT) {
            throw new IllegalStateException(
                    "Only a draft course can be submitted for review.");
        }

        if (lessons.isEmpty()) {
            throw new IllegalStateException(
                    "Course must contain at least one lesson before review.");
        }

        status = CourseStatus.REVIEW;
    }

    /**
     * Publishes a reviewed course.
     *
     * @throws IllegalStateException
     *         when the course is not in review.
     */
    public void publish() {
        if (status != CourseStatus.REVIEW) {
            throw new IllegalStateException(
                    "Only a reviewed course can be published.");
        }

        status = CourseStatus.PUBLISHED;
    }
}
