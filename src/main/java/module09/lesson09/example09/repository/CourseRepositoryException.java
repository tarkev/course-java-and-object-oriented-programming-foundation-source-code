package module09.lesson09.example09.repository;

public final class CourseRepositoryException extends RuntimeException {

    public CourseRepositoryException(String message) {
        super(message);
    }

    public CourseRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
