package module07.lesson14.example01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>(List.of(
                new Course("System Design", 800_000),
                new Course("Git", 0),
                new Course("Backend Development", 500_000),
                new Course("Java Foundation", 300_000)));

        courses.sort((first, second) ->
                Integer.compare(first.title().length(), second.title().length()));
        courses.forEach(course -> System.out.println(course.title()));

        System.out.println("---");
        courses.sort((first, second) ->
                Integer.compare(second.title().length(), first.title().length()));
        courses.forEach(course -> System.out.println(course.title()));
    }

    record Course(String title, long priceInPaisa) {
    }
}
