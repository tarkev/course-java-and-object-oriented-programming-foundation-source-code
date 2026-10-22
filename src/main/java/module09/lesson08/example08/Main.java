package module09.lesson08.example08;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("lesson.md");

        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            long headings = lines.filter(line -> line.startsWith("#")).count();
            System.out.println("Headings: " + headings);
        }
    }
}
