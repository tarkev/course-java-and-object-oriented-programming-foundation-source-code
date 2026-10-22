package module07.lesson14.example17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        AtomicInteger sent = new AtomicInteger();
        long start = System.nanoTime();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000; i++) {
                executor.submit(() -> {
                    Thread.sleep(100);
                    return sent.incrementAndGet();
                });
            }
        }

        long elapsedMillis = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Sent: " + sent.get());
        System.out.println("Elapsed: " + elapsedMillis + " ms");
    }
}
