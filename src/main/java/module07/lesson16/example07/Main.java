package module07.lesson16.example07;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static final Map<String, Integer> enrollments = new HashMap<>();

    static synchronized void enroll(String courseCode) {
        Integer current = enrollments.get(courseCode);
        if (current == null) {
            enrollments.put(courseCode, 1);
        } else {
            enrollments.put(courseCode, current + 1);
        }
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
