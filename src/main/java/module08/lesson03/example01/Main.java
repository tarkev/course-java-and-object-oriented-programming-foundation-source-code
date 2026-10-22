package module08.lesson03.example01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    static String loadContent(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException exception) {
            throw new IllegalStateException("Could not load course content.", exception);
        }
    }

    public static void main(String[] args) {
        loadContent(Path.of("missing-course.md"));
    }
}
