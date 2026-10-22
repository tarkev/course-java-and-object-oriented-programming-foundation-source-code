package module09.lesson08.example10;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path[] paths = {Path.of("missing.md"), Path.of("course-files")};

        for (Path path : paths) {
            try {
                readContent(path);
            } catch (RuntimeException exception) {
                System.out.println(exception.getClass().getSimpleName()
                        + ": " + exception.getMessage());
                System.out.println("  Cause: " + exception.getCause());
            }
        }
    }

    static String readContent(Path path) {
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (NoSuchFileException exception) {
            throw new CourseContentNotFoundException(
                    "Course content " + path + " was not found.", exception);
        } catch (IOException exception) {
            throw new CourseContentStorageException(
                    "Could not read course content " + path + ".", exception);
        }
    }
}

final class CourseContentNotFoundException extends RuntimeException {

    public CourseContentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

final class CourseContentStorageException extends RuntimeException {

    public CourseContentStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
