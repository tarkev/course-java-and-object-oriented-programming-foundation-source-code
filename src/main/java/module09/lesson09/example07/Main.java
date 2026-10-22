package module09.lesson09.example07;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Path root = Path.of("course-content");
        Files.createDirectories(root.resolve("java"));
        Files.createDirectories(root.resolve("backend"));
        String[] files = {"README.md", "overview.md", "java/oop.md",
                "java/collections.md", "java/notes.txt", "backend/api.md"};

        for (String file : files) {
            Files.writeString(root.resolve(file), "# " + file, StandardCharsets.UTF_8);
        }

        System.out.println("Direct: " + listMarkdownFiles(root));
        System.out.println("All: " + findMarkdownFiles(root));
    }

    static List<Path> listMarkdownFiles(Path directory) throws IOException {
        try (Stream<Path> entries = Files.list(directory)) {
            return entries.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".md"))
                    .sorted(Comparator.comparing(path -> path.getFileName().toString()))
                    .toList();
        }
    }

    static List<Path> findMarkdownFiles(Path root) throws IOException {
        try (Stream<Path> paths = Files.walk(root)) {
            return paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".md"))
                    .sorted()
                    .toList();
        }
    }
}
