package module09.lesson09.example08;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Path storageRoot = Files.createTempDirectory("tarkev-storage-");
        Path course = storageRoot.resolve("java-oop");

        for (String module : new String[] {"module-1", "module-2"}) {
            Files.createDirectories(course.resolve(module));
            Files.writeString(course.resolve(module).resolve("lesson.md"),
                    "# Lesson", StandardCharsets.UTF_8);
        }

        for (String courseCode : new String[] {"..", ".", "java-oop"}) {
            try {
                deleteCourse(storageRoot, courseCode);
                System.out.println("Deleted " + courseCode);
            } catch (IllegalArgumentException exception) {
                System.out.println("Rejected " + courseCode + ": "
                        + exception.getMessage());
            }
        }

        System.out.println("java-oop exists: " + Files.exists(course));
        Files.delete(storageRoot);
    }

    static void deleteCourse(Path storageRoot, String courseCode)
            throws IOException {
        Path root = storageRoot.toAbsolutePath().normalize();
        Path target = root.resolve(courseCode).normalize();

        if (!target.startsWith(root)) {
            throw new IllegalArgumentException("Target path escapes storage root.");
        }

        if (target.equals(root)) {
            throw new IllegalArgumentException("Storage root cannot be deleted.");
        }

        deleteRecursively(target);
    }

    static void deleteRecursively(Path root) throws IOException {
        if (!Files.exists(root)) {
            return;
        }

        try (Stream<Path> paths = Files.walk(root)) {
            paths.sorted(Comparator.reverseOrder()).forEach(path -> {
                try {
                    Files.deleteIfExists(path);
                } catch (IOException exception) {
                    throw new UncheckedIOException(exception);
                }
            });
        } catch (UncheckedIOException exception) {
            throw exception.getCause();
        }
    }
}
