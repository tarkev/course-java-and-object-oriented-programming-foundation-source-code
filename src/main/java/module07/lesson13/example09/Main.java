package module07.lesson13.example09;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java Foundation", 300_000, true),
                new Course("Git Basics", 0, true),
                new Course("System Design", 800_000, false),
                new Course("Backend Development", 500_000, true),
                new Course("Kotlin Preview", 0, false));

        List<String> titles = courses.stream()
                .filter(Course::published)
                .map(Course::title)
                .toList();

        System.out.println(titles);
    }

    record Course(String title, long priceInPaisa, boolean published) {
    }
}
