package module08.lesson03.example02.content;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class CourseContentLoader {

    public String load(Path path) {
        if (path == null) {
            throw new IllegalArgumentException("Content path is required.");
        }

        try {
            return Files.readString(path);
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not load course content from " + path.getFileName() + ".",
                    exception);
        }
    }
}
