package module08.lesson03.example02;

import module08.lesson03.example02.content.CourseContentLoader;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        CourseContentLoader loader = new CourseContentLoader();

        try {
            String content = loader.load(Path.of("course-content.md"));
            System.out.println(content);
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid request: " + exception.getMessage());
        } catch (IllegalStateException exception) {
            System.out.println("Content could not be loaded: " + exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
        } finally {
            System.out.println("Load attempt finished.");
        }
    }
}
