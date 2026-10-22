package module10.lesson02.example03.course;

import java.util.ArrayList;
import java.util.List;

public class CourseDemo {

    public static void main(String[] args) {
        List<Lesson> initial = new ArrayList<>();
        initial.add(new Lesson(1, "Variables"));

        Course course = new Course(new CourseCode("java-oop"), "Java", initial);

        initial.clear();
        System.out.println(course.getLessons().size());

        try {
            course.getLessons().clear();
        } catch (UnsupportedOperationException exception) {
            System.out.println("Snapshot cannot be changed");
        }

        course.addLesson(new Lesson(2, "Loops"));
        course.publish();

        try {
            course.changeTitle("Java Backend");
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println(course.getLessons().size());
    }
}
