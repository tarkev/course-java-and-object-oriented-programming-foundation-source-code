package module07.lesson05.example01;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    enum CourseStatus {
        DRAFT, PUBLISHED, ARCHIVED
    }

    record Course(
            String code,
            String title,
            CourseStatus status,
            long priceInPaisa,
            List<String> topics) {
    }

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("JAVA", "Java Foundation", CourseStatus.PUBLISHED,
                        0, List.of("Java", "OOP")),
                new Course("BACKEND", "Backend Development", CourseStatus.PUBLISHED,
                        450_000, List.of("Java", "Backend")),
                new Course("SYSTEM", "System Design", CourseStatus.DRAFT,
                        600_000, List.of("Backend", "Architecture")));

        String titles = courses.stream()
                .map(Course::title)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(titles);

        Map<CourseStatus, Long> countByStatus = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::status, TreeMap::new, Collectors.counting()));
        System.out.println(countByStatus);

        Map<Boolean, List<String>> titlesByPublished = courses.stream()
                .collect(Collectors.partitioningBy(
                        course -> course.status() == CourseStatus.PUBLISHED,
                        Collectors.mapping(Course::title, Collectors.toList())));
        System.out.println(titlesByPublished);

        long total = courses.stream().mapToLong(Course::priceInPaisa).sum();
        System.out.println("Total: " + total + " paisa");
    }
}
