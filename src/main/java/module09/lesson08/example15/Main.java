package module09.lesson08.example15;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path path = Path.of("topics.txt");

        try (InputStream input =
                new BufferedInputStream(Files.newInputStream(path))) {
            int newlines = 0;
            int value;

            while ((value = input.read()) != -1) {
                if (value == '\n') {
                    newlines++;
                }
            }

            System.out.println("Newline bytes: " + newlines);
        } catch (IOException exception) {
            throw new IllegalStateException("Could not read " + path + ".", exception);
        }
    }
}
