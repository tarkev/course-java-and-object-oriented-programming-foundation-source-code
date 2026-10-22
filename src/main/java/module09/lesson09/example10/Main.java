package module09.lesson09.example10;

import module09.lesson09.example10.course.Course;
import module09.lesson09.example10.course.CourseCode;
import module09.lesson09.example10.course.CourseStatus;
import module09.lesson09.example10.repository.CourseRepository;
import module09.lesson09.example10.repository.InMemoryCourseRepository;

public class Main {

    public static void main(String[] args) {
        CourseRepository repository = new InMemoryCourseRepository();

        CourseCode code = new CourseCode("JAVA-OOP");
        Course course = new Course(code, "Java and OOP Foundation", 499_000L);
        course.changeStatus(CourseStatus.REVIEW);

        repository.save(course);

        System.out.println(repository.findByCode(new CourseCode("java-oop")));
        System.out.println(repository.findAll().size() + " course(s) stored");
        System.out.println(repository.deleteByCode(code));
        System.out.println(repository.findByCode(code));
    }
}
