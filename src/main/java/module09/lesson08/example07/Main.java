package module09.lesson08.example07;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> topics =
                Files.readAllLines(Path.of("topics.txt"), StandardCharsets.UTF_8);

        for (int i = 0; i < topics.size(); i++) {
            System.out.println(i + 1 + ". " + topics.get(i));
        }
    }
}
