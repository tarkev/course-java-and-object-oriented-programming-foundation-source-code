package module09.lesson09.example03;

public class Main {

    public static void main(String[] args) {
        ProcessingSession session = new ProcessingSession("import-1");

        try (session) {
            session.process("JAVA-OOP");
        }

        System.out.println("Closed: " + session.isClosed());
        session.close();

        try {
            session.process("SPRING-BOOT");
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

final class ProcessingSession implements AutoCloseable {

    private final String name;
    private boolean closed;

    public ProcessingSession(String name) {
        this.name = name;
        System.out.println("Opened " + name);
    }

    public void process(String item) {
        if (closed) {
            throw new IllegalStateException("Session " + name + " is closed.");
        }

        System.out.println("Processing " + item);
    }

    public boolean isClosed() {
        return closed;
    }

    @Override
    public void close() {
        if (closed) {
            return;
        }

        closed = true;
        System.out.println("Closed " + name);
    }
}
