package module09.lesson06.example01;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileOperationsDemo {

    public static void main(String[] args) throws IOException {
        Path course = Path.of("course-demo", "java-oop");
        Path draft = course.resolve("draft.md");
        Path backup = course.resolve("draft-backup.md");

        Files.createDirectories(course);
        Files.writeString(draft, "Draft lesson");
        Files.copy(draft, backup);

        try {
            Files.copy(draft, backup);
        } catch (FileAlreadyExistsException exception) {
            System.out.println("Copy refused: " + exception.getMessage());
        }

        Files.copy(draft, backup, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Backup replaced");

        Path lesson = Files.move(draft, course.resolve("lesson.md"));
        System.out.println("Renamed to " + lesson.getFileName());

        try {
            Files.delete(course);
        } catch (DirectoryNotEmptyException exception) {
            System.out.println("Delete refused: " + exception.getMessage());
        }

        System.out.println("Deleted: " + Files.deleteIfExists(lesson));
        System.out.println("Deleted: " + Files.deleteIfExists(lesson));

        Files.delete(backup);
        Files.delete(course);
        Files.delete(course.getParent());
        System.out.println("Course exists: " + Files.exists(course));
    }
}
