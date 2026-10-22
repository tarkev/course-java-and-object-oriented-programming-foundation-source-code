package module10.lesson03.example05.course;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class OrderingDemo {

    static final class Course implements Comparable<Course> {

        private final String code;
        private final String title;

        Course(String code, String title) {
            this.code = code;
            this.title = title;
        }

        @Override
        public boolean equals(Object other) {
            return other instanceof Course course && code.equals(course.code);
        }

        @Override
        public int hashCode() {
            return code.hashCode();
        }

        @Override
        public int compareTo(Course other) {
            return title.compareTo(other.title);
        }
    }

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("JAVA-101", "Java Basics"),
                new Course("JAVA-102", "Java Basics"));

        Set<Course> hashed = new HashSet<>(courses);
        Set<Course> sorted = new TreeSet<>(courses);
        System.out.println(hashed.size() + " " + sorted.size());

        BigDecimal first = new BigDecimal("2.0");
        BigDecimal second = new BigDecimal("2.00");
        System.out.println(first.equals(second) + " " + first.compareTo(second));
        System.out.println(new HashSet<>(List.of(first, second)).size()
                + " " + new TreeSet<>(List.of(first, second)).size());
    }
}
