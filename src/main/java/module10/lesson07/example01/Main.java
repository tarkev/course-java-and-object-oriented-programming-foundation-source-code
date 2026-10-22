package module10.lesson07.example01;

import module10.lesson07.example01.course.CourseCode;
import module10.lesson07.example01.course.CourseRepository;
import module10.lesson07.example01.course.CourseService;
import module10.lesson07.example01.course.CourseSummary;
import module10.lesson07.example01.course.DuplicateCourseException;
import module10.lesson07.example01.course.storage.InMemoryCourseRepository;

public class Main {

    public static void main(String[] args) {
        CourseRepository repository = new InMemoryCourseRepository();
        CourseService service = new CourseService(repository);

        service.createCourse(
                new CourseCode("JAVA-OOP"), "Java and OOP Foundation", 499_000L);
        service.createCourse(
                new CourseCode("BACKEND"), "Backend Development", 799_000L);

        service.publishCourse(new CourseCode(" java-oop "));
        System.out.println("Published JAVA-OOP");

        try {
            service.createCourse(
                    new CourseCode(" java-oop "), "Duplicate", 100_000L);
        } catch (DuplicateCourseException exception) {
            System.out.println(exception.getMessage());
        }

        for (CourseSummary course : service.findAll()) {
            System.out.println(course);
        }
    }
}
