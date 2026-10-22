package module07.lesson13.example04;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java Foundation", 300_000, true),
                new Course("System Design", 800_000, true),
                new Course("Git Basics", 0, true),
                new Course("Spring Boot", 600_000, false),
                new Course("Kotlin Preview", 0, false));

        Predicate<Course> published = Course::published;
        Predicate<Course> paid = course -> course.priceInPaisa() > 0;
        Predicate<Course> premium = course -> course.priceInPaisa() >= 500_000;

        Predicate<Course> featured = published.and(premium);
        Predicate<Course> notForSale = published.negate().or(paid.negate());

        printMatching("Premium", courses, premium);
        printMatching("Featured", courses, featured);
        printMatching("Not for sale", courses, notForSale);
    }

    static void printMatching(String label, List<Course> courses, Predicate<Course> rule) {
        System.out.print(label + ":");
        for (Course course : courses) {
            if (rule.test(course)) {
                System.out.print(" [" + course.title() + "]");
            }
        }
        System.out.println();
    }

    record Course(String title, long priceInPaisa, boolean published) {
    }
}
