package module09.lesson08.example04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        printRegularFiles(Path.of("course-files"));
    }

    static void printRegularFiles(Path directory) {
        try (Stream<Path> entries = Files.list(directory)) {
            entries.filter(Files::isRegularFile)
                    .sorted(Comparator.comparing(
                            path -> path.getFileName().toString()))
                    .forEach(path -> System.out.println(path.getFileName()));
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not list " + directory + ".", exception);
        }
    }
}
