package module06.lesson11.example12;

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

final class Course {

    private final String code;
    private final String title;
    private final long priceInPaisa;

    Course(String code, String title, long priceInPaisa) {
        this.code = code;
        this.title = title;
        this.priceInPaisa = priceInPaisa;
    }

    String getCode() {
        return code;
    }

    String getTitle() {
        return title;
    }

    long getPriceInPaisa() {
        return priceInPaisa;
    }
}
