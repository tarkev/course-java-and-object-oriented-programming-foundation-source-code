package module09.lesson01.example01.content;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Path courseDirectory = Path.of("content", "java-oop");

        printPathInfo(courseDirectory);

        if (Files.isDirectory(courseDirectory)) {
            printChildren(courseDirectory);
        }
    }

    private static void printPathInfo(Path path) {
        System.out.println("Path: " + path);
        System.out.println("Absolute: " + path.isAbsolute());
        System.out.println(
                "Absolute path: " + path.toAbsolutePath().normalize());
        System.out.println("File name: " + path.getFileName());
        System.out.println("Parent: " + path.getParent());
        System.out.println("Exists: " + Files.exists(path));
        System.out.println("Directory: " + Files.isDirectory(path));
    }

    private static void printChildren(Path directory) {
        try (Stream<Path> paths = Files.list(directory)) {
            paths.forEach(Main::printChild);
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not list course directory.", exception);
        }
    }

    private static void printChild(Path path) {
        System.out.println();
        System.out.println("Child: " + path.getFileName());

        try {
            BasicFileAttributes attributes =
                    Files.readAttributes(path, BasicFileAttributes.class);

            System.out.println("Size: " + attributes.size());
            System.out.println("Regular file: " + attributes.isRegularFile());
            System.out.println("Directory: " + attributes.isDirectory());
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not inspect " + path + ".", exception);
        }
    }
}
