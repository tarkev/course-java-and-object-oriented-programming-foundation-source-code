package module07.lesson15.example04;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Unsafe: " + countWith(new UnsafeCounter()));
        System.out.println("Synchronized: " + countWith(new SynchronizedCounter()));
        System.out.println("Atomic: " + countWith(new AtomicCounter()));
    }

    static int countWith(CourseViewCounter counter) throws InterruptedException {
        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int view = 0; view < 50_000; view++) {
                    counter.recordView();
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return counter.views();
    }

    interface CourseViewCounter {

        void recordView();

        int views();
    }

    static final class UnsafeCounter implements CourseViewCounter {

        private int views;

        public void recordView() {
            views++;
        }

        public int views() {
            return views;
        }
    }

    static final class SynchronizedCounter implements CourseViewCounter {

        private int views;

        public synchronized void recordView() {
            views++;
        }

        public synchronized int views() {
            return views;
        }
    }

    static final class AtomicCounter implements CourseViewCounter {

        private final AtomicInteger views = new AtomicInteger();

        public void recordView() {
            views.incrementAndGet();
        }

        public int views() {
            return views.get();
        }
    }
}
