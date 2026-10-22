// Generated from modules/07-modern-java/06-optional-and-modern-null-handling.md by tools/extract_code.py. Edit the lesson, not this file.
package module07.lesson06.example01;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(
            String[] args
    ) {
        CourseRepository repository =
                new CourseRepository();

        repository.save(
                new Course(
                        "JAVA",
                        "Java Foundation",
                        true
                )
        );

        String title =
                repository
                        .findByCode(
                                "JAVA"
                        )
                        .filter(
                                Course::published
                        )
                        .map(
                                Course::title
                        )
                        .orElse(
                                "Unavailable"
                        );

        System.out.println(
                title
        );

        String missing =
                repository
                        .findByCode(
                                "BACKEND"
                        )
                        .map(
                                Course::title
                        )
                        .orElse(
                                "Not found"
                        );

        System.out.println(
                missing
        );
    }

    record Course(
            String code,
            String title,
            boolean published
    ) {
    }

    static final class CourseRepository {

        private final Map<String, Course> courses =
                new HashMap<>();

        void save(
                Course course
        ) {
            courses.put(
                    course.code(),
                    course
            );
        }

        Optional<Course> findByCode(
                String code
        ) {
            return Optional.ofNullable(
                    courses.get(
                            code
                    )
            );
        }
    }
}
