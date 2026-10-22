package module08.lesson09.example03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        try {
            loadContent("JAVA-OOP");
        } catch (CourseContentStorageException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
        }
    }

    static String loadContent(String courseCode) {
        try {
            return Files.readString(Path.of(courseCode + ".md"));
        } catch (IOException exception) {
            throw new CourseContentStorageException(courseCode, exception);
        }
    }
}

final class CourseContentStorageException extends RuntimeException {

    private final String courseCode;

    public CourseContentStorageException(String courseCode, Throwable cause) {
        super("Could not read content for course " + courseCode + ".", cause);
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }
}
