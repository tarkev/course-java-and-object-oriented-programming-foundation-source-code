package module08.lesson09.example08;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Course course = new Course("Java and OOP Foundation");
        course.addLesson("Introduction to Java");
        course.submitForReview();
        course.publish();
        System.out.println("Course published.");

        course.addLesson("Extra Lesson");
    }
}

enum CourseStatus {

    DRAFT, REVIEW, PUBLISHED, ARCHIVED;

    public boolean isEditable() {
        return this == DRAFT || this == REVIEW;
    }
}

final class Course {

    private final String title;
    private final List<String> lessons = new ArrayList<>();
    private CourseStatus status = CourseStatus.DRAFT;

    public Course(String title) {
        this.title = title;
    }

    public void addLesson(String lessonTitle) {
        if (!status.isEditable()) {
            throw new IllegalStateException(
                    "Lessons cannot be changed while course status is "
                    + status.name() + ".");
        }

        lessons.add(lessonTitle);
    }

    public void submitForReview() {
        if (lessons.isEmpty()) {
            throw new IllegalStateException(
                    "Course must contain at least one lesson before review.");
        }

        status = CourseStatus.REVIEW;
    }

    public void publish() {
        if (status != CourseStatus.REVIEW) {
            throw new IllegalStateException(
                    "Only a reviewed course can be published.");
        }

        status = CourseStatus.PUBLISHED;
    }
}
