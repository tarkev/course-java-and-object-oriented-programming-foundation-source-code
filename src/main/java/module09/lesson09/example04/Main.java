package module09.lesson09.example04;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (BrokenResource first = new BrokenResource("A");
                BrokenResource second = new BrokenResource("B")) {
            throw new IllegalStateException("Processing failed");
        } catch (IllegalStateException | IOException exception) {
            System.out.println("Primary: " + exception);

            for (Throwable suppressed : exception.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed);
            }
        }
    }
}

final class BrokenResource implements AutoCloseable {

    private final String name;

    public BrokenResource(String name) {
        this.name = name;
    }

    @Override
    public void close() throws IOException {
        throw new IOException("Close failed: " + name);
    }
}
