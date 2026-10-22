package module10.lesson01.example02;

import module10.lesson01.example02.course.CourseCode;
import module10.lesson01.example02.course.CourseRepository;
import module10.lesson01.example02.course.CourseService;
import module10.lesson01.example02.course.storage.InMemoryCourseRepository;

public class Main {

    public static void main(String[] args) {
        CourseRepository repository = new InMemoryCourseRepository();
        CourseService service = new CourseService(repository);

        service.createCourse(new CourseCode("java-oop"), "Java and OOP Foundation");
        service.createCourse(new CourseCode("SQL-101"), "SQL Basics");

        service.findAll()
                .forEach(course -> System.out.println(
                        course.getCode().value() + ": " + course.getTitle()));
    }
}
