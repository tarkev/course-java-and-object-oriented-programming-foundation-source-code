package module09.lesson05.example04;

public final class CourseSession implements AutoCloseable {

    private final String courseCode;
    private boolean closed;

    public CourseSession(String courseCode) {
        if (courseCode == null || courseCode.isBlank()) {
            throw new IllegalArgumentException("Course code is required.");
        }

        this.courseCode = courseCode.strip();
        System.out.println("Opened session for " + this.courseCode);
    }

    public void process() {
        if (closed) {
            throw new IllegalStateException("Session is already closed.");
        }

        System.out.println("Processing " + courseCode);
    }

    @Override
    public void close() {
        if (closed) {
            return;
        }

        closed = true;
        System.out.println("Closed session for " + courseCode);
    }
}
