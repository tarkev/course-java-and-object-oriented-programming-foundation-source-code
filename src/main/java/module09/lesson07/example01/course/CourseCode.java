// Generated from modules/09-file-handling-and-i-o/07-designing-a-file-based-repository.md by tools/extract_code.py. Edit the lesson, not this file.
package module09.lesson07.example01.course;

import java.util.Objects;

public final class CourseCode {

    private final String value;

    public CourseCode(
            String value
    ) {
        if (
                value == null
                || value.isBlank()
        ) {
            throw new IllegalArgumentException(
                    "Course code is required."
            );
        }

        String normalized =
                value.strip()
                        .toUpperCase();

        if (
                !normalized.matches(
                        "[A-Z0-9-]+"
                )
        ) {
            throw new IllegalArgumentException(
                    "Course code contains unsupported characters."
            );
        }

        this.value =
                normalized;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(
            Object other
    ) {
        if (
                this == other
        ) {
            return true;
        }

        if (
                !(other
                instanceof CourseCode courseCode)
        ) {
            return false;
        }

        return value.equals(
                courseCode.value
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                value
        );
    }

    @Override
    public String toString() {
        return value;
    }
}
