package module10.lesson06.example02;

import module10.lesson06.example02.course.Course;
import module10.lesson06.example02.course.CourseCode;
import module10.lesson06.example02.course.CourseService;
import module10.lesson06.example02.notification.RecordingCourseNotifier;
import module10.lesson06.example02.repository.InMemoryCourseRepository;

public class PublishCheck {

    public static void main(String[] args) {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        RecordingCourseNotifier notifier = new RecordingCourseNotifier();
        CourseService service = new CourseService(repository, notifier);

        Course course = new Course(new CourseCode("JAVA-OOP"), "Java and OOP");
        repository.save(course);
        service.publish(course.getCode());

        if (notifier.getPublishCount() != 1 || !course.isPublished()) {
            throw new AssertionError("Expected one published notification.");
        }

        System.out.println("Check passed");
    }
}
