package module07.lesson04.example02;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("JAVA-101", "Java Foundation", 500_000L, true,
                        List.of("Java", "OOP")),
                new Course("SPRING-201", "Spring Boot", 800_000L, true,
                        List.of("Java", "Spring")),
                new Course("ARCH-301", "System Design", 900_000L, false,
                        List.of("Architecture", "Scaling")),
                new Course("GIT-101", "Git Basics", 0L, true,
                        List.of("Git", "Tools")));

        List<String> topics = courses.stream()
                .filter(Course::published)
                .flatMap(course -> course.topics().stream())
                .distinct()
                .sorted()
                .limit(10)
                .toList();

        List<String> topTwo = courses.stream()
                .sorted(Comparator.comparingLong(Course::priceInPaisa)
                        .reversed())
                .limit(2)
                .map(Course::title)
                .toList();

        boolean hasFreeCourse = courses.stream()
                .anyMatch(course -> course.priceInPaisa() == 0);
        boolean allPublished = courses.stream().allMatch(Course::published);

        System.out.println("Topics: " + topics);
        System.out.println("Top two: " + topTwo);
        System.out.println("Has free course: " + hasFreeCourse);
        System.out.println("All published: " + allPublished);
    }

    record Course(
            String code,
            String title,
            long priceInPaisa,
            boolean published,
            List<String> topics) {
    }
}
