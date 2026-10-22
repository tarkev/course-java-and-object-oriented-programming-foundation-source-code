// Generated from modules/08-enums-exceptions-and-robust-error-handling/04-checked-vs-unchecked-exceptions.md by tools/extract_code.py. Edit the lesson, not this file.
package module08.lesson04.example01.content;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class CourseContentService {

    public String load(
            Path path
    ) {
        if (
                path == null
        ) {
            throw new IllegalArgumentException(
                    "Content path is required."
            );
        }

        try {
            return Files.readString(
                    path
            );
        } catch (
                IOException exception
        ) {
            throw new CourseContentLoadException(
                    "Could not load course content from "
                    + path.getFileName()
                    + ".",
                    exception
            );
        }
    }
}
