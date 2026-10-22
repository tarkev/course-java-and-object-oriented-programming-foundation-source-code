package module09.lesson08.example02;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path path = Path.of("content", "java", "lesson.md");
        System.out.println("File name: " + path.getFileName());
        System.out.println("Parent: " + path.getParent());
        System.out.println("Name count: " + path.getNameCount());
        System.out.println("Absolute: " + path.toAbsolutePath());
        System.out.println("Is absolute: " + path.isAbsolute());
    }
}
