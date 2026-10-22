package module03.lesson10.example01.course;

import java.util.Objects;

public final class CourseCode {

    private final String value;

    public CourseCode(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Course code is required.");
        }

        this.value = value.strip().toUpperCase();
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
