package module03.lesson13.example01;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Course first = new Course("JAVA", "Java Foundation");
        Course second = new Course("JAVA", "Java Foundation");

        System.out.println(first == second);
        System.out.println(first.equals(second));
    }
}

class Course {

    private final String code;
    private final String title;

    Course(String code, String title) {
        this.code = code.strip().toUpperCase();
        this.title = title.strip();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Course course = (Course) other;
        return code.equals(course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
