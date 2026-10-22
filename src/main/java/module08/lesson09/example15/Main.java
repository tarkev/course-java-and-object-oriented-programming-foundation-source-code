package module08.lesson09.example15;

public class Main {

    public static void main(String[] args) {
        Thread.currentThread().interrupt();

        try {
            waitForReport();
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
            System.out.println("Interrupt flag restored: "
                    + Thread.currentThread().isInterrupted());
        }
    }

    static void waitForReport() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(
                    "Waiting for the report was interrupted.", exception);
        }
    }
}
