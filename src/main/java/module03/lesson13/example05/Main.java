package module03.lesson13.example05;

public class Main {

    public static void main(String[] args) {
        CourseCode original = new CourseCode("foundation");
        CourseCode prefixed = original.withPrefix("java");

        System.out.println(original.getValue());
        System.out.println(prefixed.getValue());
    }
}

final class CourseCode {

    private final String value;

    CourseCode(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Course code is required.");
        }

        String normalizedValue = value.strip().toUpperCase();

        if (!normalizedValue.matches("[A-Z0-9-]+")) {
            throw new IllegalArgumentException(
                    "Course code may contain only letters, numbers, and hyphens.");
        }

        this.value = normalizedValue;
    }

    public CourseCode withPrefix(String prefix) {
        if (prefix == null || prefix.isBlank()) {
            throw new IllegalArgumentException("Prefix is required.");
        }

        return new CourseCode(prefix.strip() + "-" + value);
    }

    public String getValue() {
        return value;
    }
}
