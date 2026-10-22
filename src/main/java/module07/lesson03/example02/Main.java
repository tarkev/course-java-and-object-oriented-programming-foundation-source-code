package module07.lesson03.example02;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java Foundation", 500_000L, true),
                new Course("Backend Development", 0L, false),
                new Course("System Design", 700_000L, true),
                new Course("Git Basics", 0L, true));

        List<String> paidTitles = courses.stream()
                .filter(Course::published)
                .filter(course -> course.priceInPaisa() > 0)
                .map(Course::title)
                .toList();

        System.out.println(paidTitles);
    }

    record Course(String title, long priceInPaisa, boolean published) {
    }
}
