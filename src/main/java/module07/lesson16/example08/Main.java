package module07.lesson16.example08;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    static final Map<String, Integer> enrollments = new ConcurrentHashMap<>();

    static void enroll(String courseCode) {
        enrollments.merge(courseCode, 1, Integer::sum);
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable importer = () -> {
            for (int i = 0; i < 50_000; i++) {
                enroll("JAVA");
                enroll("SQL");
            }
        };
        Thread first = new Thread(importer);
        Thread second = new Thread(importer);
        first.start();
        second.start();
        first.join();
        second.join();

        int total = 0;
        for (int count : enrollments.values()) {
            total += count;
        }
        System.out.println(enrollments);
        System.out.println("Total: " + total + " (expected 200000)");
    }
}
