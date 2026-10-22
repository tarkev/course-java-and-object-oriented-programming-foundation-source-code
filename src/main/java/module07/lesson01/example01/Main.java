package module07.lesson01.example01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>(List.of(
                new Course("Java Foundation", 300_000L),
                new Course("System Design", 800_000L),
                new Course("Backend Development", 500_000L)));

        courses.sort(Comparator.comparingLong(Course::priceInPaisa));

        courses.forEach(course ->
                System.out.println(course.title() + " - " + course.priceInPaisa()));
    }

    record Course(String title, long priceInPaisa) {
    }
}
