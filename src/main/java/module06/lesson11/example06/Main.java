package module06.lesson11.example06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java Basics", 1500),
                new Course("Spring Boot", 2000),
                new Course("Docker", 1200),
                new Course("Algorithms", 1800),
                new Course("Kubernetes", 2500),
                new Course("Git", 500));

        for (Course course : mostExpensive(courses, 3)) {
            System.out.println(course.getTitle() + " " + course.getPrice());
        }

        System.out.println("k = 10: " + mostExpensive(courses, 10).size() + " courses");
    }

    static List<Course> mostExpensive(List<Course> courses, int k) {
        PriorityQueue<Course> heap =
                new PriorityQueue<>(Comparator.comparingLong(Course::getPrice));

        for (Course course : courses) {
            heap.offer(course);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Course> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(0, heap.poll());
        }

        return result;
    }
}

class Course {
    private final String title;
    private final long price;

    Course(String title, long price) {
        this.title = title;
        this.price = price;
    }

    String getTitle() {
        return title;
    }

    long getPrice() {
        return price;
    }
}
