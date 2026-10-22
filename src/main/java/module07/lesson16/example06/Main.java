package module07.lesson16.example06;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ProgressReporter reporter = new ProgressReporter();
        Thread thread = new Thread(reporter::run);

        thread.start();
        Thread.sleep(200);
        reporter.stop();
        thread.join();

        System.out.println("Reporter stopped");
    }

    static final class ProgressReporter {

        private volatile boolean running = true;
        private long checks;

        void run() {
            while (running) {
                checks++;
            }
        }

        void stop() {
            running = false;
        }
    }
}
