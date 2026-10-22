package module07.lesson14.example12;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> titles = sampleCourses().stream()
                .filter(Course::published)
                .map(Course::title)
                .sorted()
                .toList();

        System.out.println(titles);
    }

    static List<Course> sampleCourses() {
        return List.of(
                new Course("JAVA", "Java Foundation", 300_000, true, List.of("Java", "OOP")),
                new Course("GIT", "Git Basics", 0, true, List.of("Git", "Tools")),
                new Course("SPRING", "Spring Boot", 600_000, true, List.of("Java", "Spring")),
                new Course("SYSTEM", "System Design", 800_000, false,
                        List.of("Architecture", "Scaling")),
                new Course("BACKEND", "Backend Development", 500_000, true,
                        List.of("Java", "Backend", "Spring")),
                new Course("CLEAN", "Clean Code", 250_000, true, List.of("Java", "Design")));
    }

    record Course(
            String code,
            String title,
            long priceInPaisa,
            boolean published,
            List<String> topics) {
    }
}
