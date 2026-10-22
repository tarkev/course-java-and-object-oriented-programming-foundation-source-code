// Generated from modules/07-modern-java/09-records-and-modern-data-models.md by tools/extract_code.py. Edit the lesson, not this file.
package module07.lesson09.example01;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Main {

    public static void main(
            String[] args
    ) {
        CourseCode code =
                new CourseCode(
                        " java-foundation "
                );

        CourseSummary first =
                new CourseSummary(
                        code,
                        "Java Foundation",
                        300_000,
                        List.of(
                                "Java",
                                "OOP"
                        )
                );

        CourseSummary second =
                new CourseSummary(
                        new CourseCode(
                                "JAVA-FOUNDATION"
                        ),
                        "Java Foundation",
                        300_000,
                        List.of(
                                "Java",
                                "OOP"
                        )
                );

        System.out.println(
                first
        );

        System.out.println(
                first.equals(
                        second
                )
        );
    }

    record CourseCode(
            String value
    ) {

        CourseCode {
            value =
                    Objects.requireNonNull(
                            value,
                            "Course code is required."
                    )
                            .strip()
                            .toUpperCase(
                                    Locale.ROOT
                            );

            if (
                    value.isBlank()
                    || !value.matches(
                            "[A-Z0-9-]+"
                    )
            ) {
                throw new IllegalArgumentException(
                        "Invalid course code: "
                        + value
                );
            }
        }
    }

    record CourseSummary(
            CourseCode code,
            String title,
            long priceInPaisa,
            List<String> topics
    ) {

        CourseSummary {
            Objects.requireNonNull(
                    code,
                    "Course code is required."
            );

            title =
                    Objects.requireNonNull(
                            title,
                            "Course title is required."
                    ).strip();

            if (
                    title.isBlank()
            ) {
                throw new IllegalArgumentException(
                        "Course title is required."
                );
            }

            if (
                    priceInPaisa < 0
            ) {
                throw new IllegalArgumentException(
                        "Price cannot be negative."
                );
            }

            topics =
                    List.copyOf(
                            Objects.requireNonNull(
                                    topics,
                                    "Topics are required."
                            )
                    );
        }
    }
}
