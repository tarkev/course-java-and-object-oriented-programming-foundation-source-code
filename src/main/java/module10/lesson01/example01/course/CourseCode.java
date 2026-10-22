// Generated from modules/10-professional-java-practices/01-organizing-java-applications-with-packages.md by tools/extract_code.py. Edit the lesson, not this file.
package module10.lesson01.example01.course;

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

        this.value =
                value.strip()
                        .toUpperCase();
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
}
