package module06.lesson05.example01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>(List.of(
                new Course("JAVA", "Java Foundation", 300_000L),
                new Course("SYSTEM-DESIGN", "System Design", 800_000L),
                new Course("BACKEND", "Backend Development", 500_000L),
                new Course("ALGORITHMS", "Algorithms", 500_000L)));

        Comparator<Course> byPriceThenTitle =
                Comparator.comparingLong(Course::getPriceInPaisa)
                        .thenComparing(Course::getTitle);

        courses.sort(byPriceThenTitle);

        for (Course course : courses) {
            System.out.println(
                    course.getTitle() + " - " + course.getPriceInPaisa());
        }
    }
}
