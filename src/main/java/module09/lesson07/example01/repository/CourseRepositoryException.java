package module09.lesson07.example01.repository;

public final class CourseRepositoryException extends RuntimeException {

    public CourseRepositoryException(String message) {
        super(message);
    }

    public CourseRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
