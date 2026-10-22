package module08.lesson04.example02;

import module08.lesson04.example02.content.CourseContentLoadException;
import module08.lesson04.example02.content.CourseContentService;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        CourseContentService service = new CourseContentService();

        try {
            String content = service.load(Path.of("java-oop.md"));

            System.out.println(content);
        } catch (CourseContentLoadException exception) {
            System.out.println("Course content is temporarily unavailable.");

            System.err.println(exception.getMessage());
            System.err.println("Cause: " + exception.getCause());
        }
    }
}
