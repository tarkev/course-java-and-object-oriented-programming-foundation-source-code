package module09.lesson05.example02;

import java.io.IOException;

public class SuppressedDemo {

    public static void main(String[] args) {
        try (BrokenResource resource = new BrokenResource()) {
            throw new IllegalStateException("Processing failed");
        } catch (IllegalStateException | IOException exception) {
            System.out.println("Primary: " + exception);

            for (Throwable suppressed : exception.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed);
            }
        }
    }
}
