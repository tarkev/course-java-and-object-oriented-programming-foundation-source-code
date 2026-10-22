package module09.lesson08.example12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) throws IOException {
        Path log = Path.of("events.log");
        appendEvent(log, "COURSE_CREATED");
        appendEvent(log, "COURSE_PUBLISHED");
        System.out.println(Files.readAllLines(log, StandardCharsets.UTF_8));
    }

    static void appendEvent(Path path, String event) {
        try {
            Files.writeString(path, event + System.lineSeparator(),
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException exception) {
            throw new IllegalStateException("Could not append event.", exception);
        }
    }
}
