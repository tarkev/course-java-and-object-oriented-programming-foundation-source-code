package module07.lesson10.example02;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread first = new Thread(() -> incrementManyTimes(counter));
        Thread second = new Thread(() -> incrementManyTimes(counter));

        first.start();
        second.start();
        first.join();
        second.join();

        System.out.println(counter.value());
    }

    static void incrementManyTimes(Counter counter) {
        for (int i = 0; i < 100_000; i++) {
            counter.increment();
        }
    }

    static final class Counter {

        private int count;

        void increment() {
            count++;
        }

        int value() {
            return count;
        }
    }
}
