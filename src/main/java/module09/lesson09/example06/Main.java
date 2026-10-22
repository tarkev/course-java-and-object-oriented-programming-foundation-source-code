package module09.lesson09.example06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Path template = Path.of("template.md");
        Files.writeString(template, "# Lesson Title\n", StandardCharsets.UTF_8);
        Path target = Path.of("content", "java-oop", "introduction.md");

        copyTemplate(template, target);
        System.out.println("Copied to " + target);

        try {
            copyTemplate(template, target);
        } catch (LessonAlreadyExistsException exception) {
            System.out.println(exception.getMessage());
        }
    }

    static void copyTemplate(Path template, Path target) {
        try {
            Path parent = target.getParent();

            if (parent != null) {
                Files.createDirectories(parent);
            }

            Files.copy(template, target);
        } catch (FileAlreadyExistsException exception) {
            throw new LessonAlreadyExistsException("Lesson "
                    + target.getFileName() + " already exists and was not replaced.",
                    exception);
        } catch (IOException exception) {
            throw new IllegalStateException("Could not copy the template.", exception);
        }
    }
}

final class LessonAlreadyExistsException extends RuntimeException {

    public LessonAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
