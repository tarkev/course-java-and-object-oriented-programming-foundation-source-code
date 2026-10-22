package module07.lesson15.example01;

import java.util.List;
import java.util.Map;
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

        Map<String, String> titlesByCode = courses.stream()
                .collect(Collectors.toMap(Course::code, Course::title));

        System.out.println(titlesByCode.get("JAVA"));
        System.out.println(titlesByCode.get("SYSTEM"));
        System.out.println(titlesByCode.size() + " courses");
    }
}
