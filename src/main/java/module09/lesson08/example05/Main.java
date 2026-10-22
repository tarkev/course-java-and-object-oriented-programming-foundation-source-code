package module09.lesson08.example05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        printFileMetadata(Path.of("course-files", "introduction.md"));

        try {
            printFileMetadata(Path.of("course-files", "missing.md"));
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
        }
    }

    static void printFileMetadata(Path path) {
        try {
            BasicFileAttributes attributes =
                    Files.readAttributes(path, BasicFileAttributes.class);

            System.out.println("Size: " + attributes.size());
            System.out.println("Created: " + attributes.creationTime());
            System.out.println("Modified: " + attributes.lastModifiedTime());
            System.out.println("Regular file: " + attributes.isRegularFile());
            System.out.println("Directory: " + attributes.isDirectory());
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not read metadata of " + path.getFileName() + ".",
                    exception);
        }
    }
}
