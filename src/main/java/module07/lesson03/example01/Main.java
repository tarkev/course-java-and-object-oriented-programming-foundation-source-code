// Generated from modules/07-modern-java/03-introduction-to-the-stream-api.md by tools/extract_code.py. Edit the lesson, not this file.
package module07.lesson03.example01;

import java.util.List;

public class Main {

    public static void main(
            String[] args
    ) {
        List<Course> courses =
                List.of(
                        new Course(
                                "Java Foundation",
                                true
                        ),
                        new Course(
                                "Backend Development",
                                false
                        ),
                        new Course(
                                "System Design",
                                true
                        )
                );

        List<String> titles =
                courses.stream()
                        .filter(
                                Course::published
                        )
                        .map(
                                Course::title
                        )
                        .toList();

        System.out.println(
                titles
        );
    }

    record Course(
            String title,
            boolean published
    ) {
    }
}
