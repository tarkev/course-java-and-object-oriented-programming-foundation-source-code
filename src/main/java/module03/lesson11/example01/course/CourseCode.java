// Generated from modules/03-object-oriented-programming-foundations/11-project-build-a-course-enrollment-system.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson11.example01.course;

import java.util.Objects;

public final class CourseCode {

    private final String value;

    public CourseCode(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Course code is required.");
        }

        String normalizedValue = value.strip().toUpperCase();

        if (!normalizedValue.matches("[A-Z0-9]+(?:-[A-Z0-9]+)*")) {
            throw new IllegalArgumentException(
                    "Course code may contain only letters, numbers, "
                    + "and hyphens between parts.");
        }

        this.value = normalizedValue;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        CourseCode courseCode = (CourseCode) other;

        return value.equals(courseCode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
