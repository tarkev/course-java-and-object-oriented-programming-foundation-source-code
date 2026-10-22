package module09.lesson09.example02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Path source = Path.of("course-export.txt");
        Files.writeString(source, "JAVA-OOP;Java and OOP Foundation\n",
                StandardCharsets.UTF_8);
        System.out.println("Copied " + copy(source, Path.of("backup.txt")) + " bytes");
    }

    static long copy(Path source, Path target) {
        try (InputStream input = Files.newInputStream(source);
                OutputStream output = Files.newOutputStream(target)) {
            return input.transferTo(output);
        } catch (IOException exception) {
            throw new IllegalStateException("Could not copy " + source + ".", exception);
        }
    }
}
