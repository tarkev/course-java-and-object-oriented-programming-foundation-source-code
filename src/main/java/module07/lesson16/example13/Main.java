package module07.lesson16.example13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore slots = new Semaphore(3);
        RunningTracker tracker = new RunningTracker();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 20; i++) {
                int reportNumber = i;
                executor.submit(() -> {
                    slots.acquire();
                    try {
                        tracker.enter();
                        Thread.sleep(50);
                        tracker.leave();
                    } finally {
                        slots.release();
                    }
                    return "Report " + reportNumber;
                });
            }
        }

        System.out.println("Highest at once: " + tracker.highest());
    }

    static final class RunningTracker {

        private int running;
        private int highest;

        synchronized void enter() {
            running++;
            highest = Math.max(highest, running);
        }

        synchronized void leave() {
            running--;
        }

        synchronized int highest() {
            return highest;
        }
    }
}
