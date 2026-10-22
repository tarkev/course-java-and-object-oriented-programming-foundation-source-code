package module10.lesson06.example01;

import module10.lesson06.example01.course.Course;
import module10.lesson06.example01.course.CourseCode;
import module10.lesson06.example01.course.CourseService;
import module10.lesson06.example01.notification.ConsoleCourseNotifier;
import module10.lesson06.example01.notification.CourseNotifier;
import module10.lesson06.example01.repository.CourseRepository;
import module10.lesson06.example01.repository.InMemoryCourseRepository;

public class Main {

    public static void main(String[] args) {
        CourseRepository repository = new InMemoryCourseRepository();
        CourseNotifier notifier = new ConsoleCourseNotifier();
        CourseService service = new CourseService(repository, notifier);

        CourseCode code = new CourseCode("JAVA-OOP");
        repository.save(new Course(code, "Java and OOP Foundation"));

        service.publish(code);
    }
}
