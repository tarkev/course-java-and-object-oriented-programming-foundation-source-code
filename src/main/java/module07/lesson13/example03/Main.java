package module07.lesson13.example03;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Course> sample = List.of(
                new Course("Java Foundation", 300_000),
                new Course("Intro to Git", 400_000),
                new Course("System Design", 900_000),
                new Course("Backend Development", 500_000));

        List<Course> before = new ArrayList<>(sample);
        before.removeIf(course ->
                !(course.priceInPaisa() >= 300_000
                        && course.priceInPaisa() <= 800_000
                        && !course.title().startsWith("Intro")));

        List<Course> after = new ArrayList<>(sample);
        after.removeIf(course -> !isEligibleForPromotion(course));

        System.out.println(after);
        System.out.println("Same result: " + before.equals(after));
    }

    static boolean isEligibleForPromotion(Course course) {
        return course.priceInPaisa() >= 300_000
                && course.priceInPaisa() <= 800_000
                && !course.title().startsWith("Intro");
    }

    record Course(String title, long priceInPaisa) {
    }
}
