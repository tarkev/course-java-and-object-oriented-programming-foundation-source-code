package module10.lesson02.example03.course;

import java.util.Locale;

public record CourseCode(String value) {

    public CourseCode {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Course code is required.");
        }

        value = value.strip().toUpperCase(Locale.ROOT);

        if (!value.matches("[A-Z0-9-]+")) {
            throw new IllegalArgumentException(
                    "Course code contains unsupported characters.");
        }
    }
}
