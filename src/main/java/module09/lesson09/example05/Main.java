package module09.lesson09.example05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path created = createCourseDirectory(Path.of("content"), "java-oop");
        System.out.println(created.getFileName() + " is a directory: "
                + Files.isDirectory(created));

        for (String courseCode : new String[] {"../secret", "."}) {
            try {
                createCourseDirectory(Path.of("content"), courseCode);
            } catch (IllegalArgumentException exception) {
                System.out.println("Rejected " + courseCode + ": "
                        + exception.getMessage());
            }
        }
    }

    static Path createCourseDirectory(Path base, String courseCode) {
        if (base == null || courseCode == null || courseCode.isBlank()) {
            throw new IllegalArgumentException(
                    "Base directory and course code are required.");
        }

        Path normalizedBase = base.toAbsolutePath().normalize();
        Path target = normalizedBase.resolve(courseCode).normalize();

        if (!target.startsWith(normalizedBase)) {
            throw new IllegalArgumentException("Path escapes the base directory.");
        }

        if (target.equals(normalizedBase)) {
            throw new IllegalArgumentException("Path is the base directory itself.");
        }

        try {
            return Files.createDirectories(target);
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not create directory for " + courseCode + ".", exception);
        }
    }
}
