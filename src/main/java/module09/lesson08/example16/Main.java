package module09.lesson08.example16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Path target = Path.of("clean.md");
        removeBlankLines(Path.of("draft.md"), target);
        System.out.println(Files.readAllLines(target, StandardCharsets.UTF_8));
    }

    static void removeBlankLines(Path source, Path target) {
        try (BufferedReader reader =
                        Files.newBufferedReader(source, StandardCharsets.UTF_8);
                BufferedWriter writer =
                        Files.newBufferedWriter(target, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException exception) {
            throw new IllegalStateException("Could not transform text file.", exception);
        }
    }
}
