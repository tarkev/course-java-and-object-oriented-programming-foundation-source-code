package module05.lesson11.example10;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<CourseCode> codes = new HashSet<>();
        System.out.println(codes.add(new CourseCode("java")));
        System.out.println(codes.add(new CourseCode("JAVA")));
        System.out.println(codes.size());
        System.out.println(codes);
    }
}

final class CourseCode {
    private final String value;

    CourseCode(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Course code is required.");
        }
        this.value = value.strip().toUpperCase();
    }

    String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CourseCode courseCode)) {
            return false;
        }
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
