package module08.lesson04.example02.content;

public final class CourseContentLoadException extends RuntimeException {

    public CourseContentLoadException(String message) {
        super(message);
    }

    public CourseContentLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
