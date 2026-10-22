package module07.lesson16.example05;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CourseSeats seats = new CourseSeats(100);
        AtomicInteger succeeded = new AtomicInteger();

        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int attempt = 0; attempt < 1_000; attempt++) {
                    if (seats.reserve()) {
                        succeeded.incrementAndGet();
                    }
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Successful reservations: " + succeeded.get());
        System.out.println("Reserved seats: " + seats.reserved());
    }

    static final class CourseSeats {

        private final int capacity;
        private int reserved;

        CourseSeats(int capacity) {
            this.capacity = capacity;
        }

        synchronized boolean reserve() {
            if (reserved >= capacity) {
                return false;
            }
            reserved++;
            return true;
        }

        synchronized int reserved() {
            return reserved;
        }
    }
}
