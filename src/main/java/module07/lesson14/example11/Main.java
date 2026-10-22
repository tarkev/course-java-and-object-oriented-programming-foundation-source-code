package module07.lesson14.example11;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java Foundation", 300_000, true),
                new Course("Git Basics", 0, true),
                new Course("Spring Boot", 600_000, false),
                new Course("System Design", 800_000, true),
                new Course("Backend Development", 500_000, true));

        // A loop: the stop condition depends on a running total that
        // changes with every printed course, which a stream cannot
        // express without a hidden side effect.
        long totalInPaisa = 0;
        for (Course course : courses) {
            if (!course.published()) {
                continue;
            }
            System.out.println(course.title());
            totalInPaisa += course.priceInPaisa();
            if (totalInPaisa > 1_000_000) {
                break;
            }
        }
    }

    record Course(String title, long priceInPaisa, boolean published) {
    }
}
