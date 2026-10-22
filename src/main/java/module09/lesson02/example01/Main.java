package module09.lesson02.example01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("content", "lesson.md");

        String content = Files.readString(path, StandardCharsets.UTF_8);

        System.out.println(content);
    }
}
