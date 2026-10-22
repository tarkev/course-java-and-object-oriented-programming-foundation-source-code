package module08.lesson09.example14;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Course course = new Course();
        System.out.println(course.publish());

        course.addLesson("Introduction to Java");
        System.out.println(course.publish());

        course.approve();
        System.out.println(course.publish());
        System.out.println(course.publish());
    }
}

enum PublishResult {
    PUBLISHED, ALREADY_PUBLISHED, NO_LESSONS, NOT_APPROVED
}

enum CourseStatus {
    DRAFT, APPROVED, PUBLISHED
}

final class Course {

    private final List<String> lessons = new ArrayList<>();
    private CourseStatus status = CourseStatus.DRAFT;

    public void addLesson(String lessonTitle) {
        lessons.add(lessonTitle);
    }

    public void approve() {
        status = CourseStatus.APPROVED;
    }

    public PublishResult publish() {
        if (status == CourseStatus.PUBLISHED) {
            return PublishResult.ALREADY_PUBLISHED;
        }

        if (lessons.isEmpty()) {
            return PublishResult.NO_LESSONS;
        }

        if (status != CourseStatus.APPROVED) {
            return PublishResult.NOT_APPROVED;
        }

        status = CourseStatus.PUBLISHED;
        return PublishResult.PUBLISHED;
    }
}
