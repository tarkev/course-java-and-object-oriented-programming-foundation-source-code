package module06.lesson10.example05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>(List.of(
                new Course("JAVA-21", "Java Foundation", 300_000L),
                new Course("BACKEND", "Backend Development", 500_000L),
                new Course("JAVA-17", "Java Foundation", 250_000L)));

        courses.sort(Comparator.comparing(Course::getTitle)
                .thenComparing(Course::getCode));

        for (Course course : courses) {
            System.out.println(course.getTitle() + " - " + course.getCode());
        }
    }
}
