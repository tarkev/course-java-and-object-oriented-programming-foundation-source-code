package module08.lesson09.example13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        ContentSource source = new FileContentSource();

        try {
            System.out.println(source.load("JAVA-OOP"));
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
        }
    }
}

interface ContentSource {

    String load(String courseCode);
}

class FileContentSource implements ContentSource {

    @Override
    public String load(String courseCode) {
        try {
            return Files.readString(Path.of(courseCode + ".md"));
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not load content for course " + courseCode + ".",
                    exception);
        }
    }
}
