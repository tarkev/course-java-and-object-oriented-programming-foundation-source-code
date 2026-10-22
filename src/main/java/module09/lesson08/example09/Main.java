package module09.lesson08.example09;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path path = Path.of("notes.txt");

        try (BufferedReader reader =
                Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            int number = 1;

            while ((line = reader.readLine()) != null) {
                System.out.println(number + ": " + line);
                number++;
            }
        } catch (IOException exception) {
            throw new IllegalStateException("Could not read " + path + ".", exception);
        }
    }
}
