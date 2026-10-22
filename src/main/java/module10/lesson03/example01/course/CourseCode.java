package module10.lesson03.example01.course;

import java.util.Locale;
import java.util.Objects;

public final class CourseCode {

    private final String value;

    public CourseCode(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Course code is required.");
        }

        this.value = value.strip().toUpperCase(Locale.ROOT);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof CourseCode code)) {
            return false;
        }

        return value.equals(code.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
