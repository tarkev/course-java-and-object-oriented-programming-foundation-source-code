package module09.lesson09.example09;

import module09.lesson09.example09.course.CourseCode;
import module09.lesson09.example09.repository.CourseRepository;
import module09.lesson09.example09.repository.CourseRepositoryException;
import module09.lesson09.example09.repository.FileCourseRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Path directory = Path.of("data", "courses");
        Files.createDirectories(directory);
        Files.writeString(directory.resolve("java.properties"),
                "code=JAVA\ntitle=Java\npriceInPaisa=hello\nstatus=DRAFT\n",
                StandardCharsets.UTF_8);

        CourseRepository repository = new FileCourseRepository(directory);

        try {
            System.out.println(repository.findByCode(new CourseCode("JAVA")));
        } catch (CourseRepositoryException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
        }
    }
}
