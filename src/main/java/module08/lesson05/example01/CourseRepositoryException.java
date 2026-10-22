package module08.lesson05.example01;

public class CourseRepositoryException extends RuntimeException {

    public CourseRepositoryException(String message) {
        super(message);
    }

    public CourseRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
