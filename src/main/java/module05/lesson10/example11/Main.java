package module05.lesson10.example11;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<MutableCourse> courses = new HashSet<>();
        MutableCourse course = new MutableCourse("JAVA");
        courses.add(course);

        course.setCode("SPRING");

        System.out.println(courses.contains(course));
        System.out.println(courses.remove(course));
        System.out.println(courses.size());
    }
}

final class MutableCourse {
    private String code;

    MutableCourse(String code) {
        this.code = code;
    }

    void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MutableCourse course)) {
            return false;
        }
        return code.equals(course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
