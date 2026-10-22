package module09.lesson09.example01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("lesson.md");
        Files.writeString(path, "# Try-With-Resources\nResources must be closed.\n",
                StandardCharsets.UTF_8);
        System.out.println(readFirstLine(path));

        try {
            readFirstLine(Path.of("missing.md"));
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
        }
    }

    static String readFirstLine(Path path) {
        try (BufferedReader reader =
                Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            return reader.readLine();
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not read the first line of " + path + ".", exception);
        }
    }
}
