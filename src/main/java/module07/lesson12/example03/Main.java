package module07.lesson12.example03;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> enrollmentCounts =
                new ConcurrentHashMap<>();

        try (ExecutorService executor =
                Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000; i++) {
                executor.submit(() -> enrollmentCounts.merge("JAVA", 1, Integer::sum));
            }
        }

        System.out.println("JAVA: " + enrollmentCounts.get("JAVA"));
    }
}
