package module02.lesson11.example10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] courses = {"Java", "Backend"};
        String[] copy = Arrays.copyOf(courses, courses.length);

        copy[1] = "Spring";

        System.out.println(Arrays.toString(courses));
        System.out.println(Arrays.toString(copy));
    }
}
