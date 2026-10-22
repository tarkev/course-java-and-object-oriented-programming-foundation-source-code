package module08.lesson08.example11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        try {
            loadLesson(Path.of("lesson-01.md"));
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
        }
    }

    static String loadLesson(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException exception) {
            throw new IllegalStateException("Could not load lesson content.", exception);
        }
    }
}
