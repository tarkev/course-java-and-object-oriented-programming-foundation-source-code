package module05.lesson11.example08;

import java.util.HashSet;
import java.util.Set;

public class Main {

    static boolean addCourseCode(
            Set<String> courseCodes, String courseCode) {
        if (courseCode == null || courseCode.isBlank()) {
            return false;
        }
        String normalized = courseCode.strip().toUpperCase();
        return courseCodes.add(normalized);
    }

    public static void main(String[] args) {
        Set<String> courseCodes = new HashSet<>();
        System.out.println(addCourseCode(courseCodes, "java-101"));
        System.out.println(addCourseCode(courseCodes, "  JAVA-101 "));
        System.out.println(addCourseCode(courseCodes, "   "));
        System.out.println(addCourseCode(courseCodes, null));
        System.out.println(addCourseCode(courseCodes, "spring-201"));
        System.out.println(courseCodes.size());
    }
}
