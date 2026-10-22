package module07.lesson13.example06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>(List.of(
                new Course("System Design", 800_000, true),
                new Course("Spring Boot", 500_000, true),
                new Course("Backend Development", 500_000, true),
                new Course("Java Foundation", 300_000, true)));

        Comparator<Course> byPrice = Comparator.comparingLong(Course::priceInPaisa);

        courses.sort(byPrice.thenComparing(Course::title));
        courses.forEach(course -> System.out.println(course.title()));

        System.out.println("---");
        courses.sort(byPrice.reversed().thenComparing(Course::title));
        courses.forEach(course -> System.out.println(course.title()));
    }

    record Course(String title, long priceInPaisa, boolean published) {
    }
}
