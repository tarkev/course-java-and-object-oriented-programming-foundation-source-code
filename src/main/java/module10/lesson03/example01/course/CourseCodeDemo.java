package module10.lesson03.example01.course;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseCodeDemo {

    public static void main(String[] args) {
        CourseCode first = new CourseCode("JAVA-OOP");
        CourseCode second = new CourseCode(" java-oop ");

        System.out.println(first == second);
        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());

        Set<CourseCode> codes = new HashSet<>();
        codes.add(first);
        codes.add(second);
        System.out.println(codes.size());

        Map<CourseCode, String> titles = new HashMap<>();
        titles.put(first, "Java and OOP Foundation");
        System.out.println(titles.get(new CourseCode("Java-Oop")));
    }
}
