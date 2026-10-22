package module09.lesson08.example06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        System.out.print(readMarkdown(Path.of("course-files", "introduction.md")));

        try {
            readMarkdown(Path.of("missing.md"));
        } catch (CourseContentStorageException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
        }
    }

    static String readMarkdown(Path path) {
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new CourseContentStorageException(
                    "Could not read Markdown file " + path.getFileName() + ".",
                    exception);
        }
    }
}

final class CourseContentStorageException extends RuntimeException {

    public CourseContentStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
