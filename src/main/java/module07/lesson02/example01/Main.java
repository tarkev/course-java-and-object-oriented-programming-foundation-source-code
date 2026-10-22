// Generated from modules/07-modern-java/02-functional-interfaces-and-method-references.md by tools/extract_code.py. Edit the lesson, not this file.
package module07.lesson02.example01;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(
            String[] args
    ) {
        List<Course> courses =
                List.of(
                        new Course(
                                "Java Foundation",
                                300_000L,
                                true
                        ),
                        new Course(
                                "System Design",
                                800_000L,
                                false
                        ),
                        new Course(
                                "Backend Development",
                                500_000L,
                                true
                        )
                );

        Predicate<Course> paid =
                course ->
                        course.priceInPaisa()
                        > 0;

        Predicate<Course> published =
                Course::published;

        Predicate<Course> purchasable =
                paid.and(
                        published
                );

        Function<Course, String> title =
                Course::title;

        for (
                Course course
                : courses
        ) {
            if (
                    purchasable.test(
                            course
                    )
            ) {
                System.out.println(
                        title.apply(
                                course
                        )
                );
            }
        }
    }

    record Course(
            String title,
            long priceInPaisa,
            boolean published
    ) {
    }
}
