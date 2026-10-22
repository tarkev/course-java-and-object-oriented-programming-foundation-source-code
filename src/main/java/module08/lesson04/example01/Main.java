// Generated from modules/08-enums-exceptions-and-robust-error-handling/04-checked-vs-unchecked-exceptions.md by tools/extract_code.py. Edit the lesson, not this file.
package module08.lesson04.example01;

import module08.lesson04.example01.content.CourseContentLoadException;
import module08.lesson04.example01.content.CourseContentService;

import java.nio.file.Path;

public class Main {

    public static void main(
            String[] args
    ) {
        CourseContentService service =
                new CourseContentService();

        try {
            String content =
                    service.load(
                            Path.of(
                                    "course.md"
                            )
                    );

            System.out.println(
                    content
            );
        } catch (
                CourseContentLoadException exception
        ) {
            System.out.println(
                    "Course content is temporarily unavailable."
            );

            System.err.println(
                    exception.getMessage()
            );
        }
    }
}
