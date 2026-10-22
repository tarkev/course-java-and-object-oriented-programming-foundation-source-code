package module07.lesson03.example01;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java Foundation", 500_000L, true),
                new Course("Backend Development", 800_000L, false),
                new Course("System Design", 700_000L, true));

        Stream<String> titles = courses.stream()
                .filter(course -> {
                    System.out.println("filter: " + course.title());
                    return course.published();
                })
                .map(course -> {
                    System.out.println("map: " + course.title());
                    return course.title();
                });

        System.out.println("Pipeline built");

        List<String> result = titles.toList();

        System.out.println(result);
    }

    record Course(String title, long priceInPaisa, boolean published) {
    }
}
