package module05.lesson12.example08;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Course> findFreeCourses(List<Course> courses) {
        if (courses == null) {
            return List.of();
        }

        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course != null && course.getPriceInPaisa() == 0) {
                result.add(course);
            }
        }
        return List.copyOf(result);
    }

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course(1L, "Java Basics", 0),
                new Course(2L, "Spring Boot", 250000),
                new Course(3L, "Git Basics", 0));

        List<Course> freeCourses = findFreeCourses(courses);
        for (Course course : freeCourses) {
            System.out.println(course.getTitle());
        }
        System.out.println(courses.size());
        System.out.println(findFreeCourses(null).size());
    }
}

final class Course {
    private final long id;
    private final String title;
    private final long priceInPaisa;

    Course(long id, String title, long priceInPaisa) {
        this.id = id;
        this.title = title;
        this.priceInPaisa = priceInPaisa;
    }

    long getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    long getPriceInPaisa() {
        return priceInPaisa;
    }
}
