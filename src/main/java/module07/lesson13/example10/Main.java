package module07.lesson13.example10;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java Foundation", 300_000, true),
                new Course("System Design", 800_000, false),
                new Course("Git Basics", 0, true));

        Stream<String> pipeline = courses.stream()
                .filter(course -> {
                    System.out.println("filter: " + course.title());
                    return course.published();
                })
                .map(course -> {
                    System.out.println("map: " + course.title());
                    return course.title();
                });

        System.out.println("Pipeline built");
        List<String> titles = pipeline.toList();
        System.out.println(titles);
    }

    record Course(String title, long priceInPaisa, boolean published) {
    }
}
