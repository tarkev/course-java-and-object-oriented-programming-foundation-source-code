package module09.lesson08.example11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) {
        Path path = Path.of("welcome.md");
        createContent(path, "# Welcome\n");
        System.out.println("Created " + path);

        try {
            createContent(path, "# Welcome again\n");
        } catch (CourseContentAlreadyExistsException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
        }
    }

    static void createContent(Path path, String content) {
        try {
            Files.writeString(path, content, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE_NEW);
        } catch (FileAlreadyExistsException exception) {
            throw new CourseContentAlreadyExistsException(
                    "Content " + path + " already exists.", exception);
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not create content " + path + ".", exception);
        }
    }
}

final class CourseContentAlreadyExistsException extends RuntimeException {

    public CourseContentAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
