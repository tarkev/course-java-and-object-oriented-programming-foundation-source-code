package module10.lesson10.example01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> lessons = new ArrayList<>(List.of("Variables"));
        CoursePlan plan = new CoursePlan(lessons);
        lessons.add("Loops");
        System.out.println(plan.getLessons());

        try {
            plan.getLessons().clear();
        } catch (UnsupportedOperationException exception) {
            System.out.println("The plan cannot be changed");
        }

        try {
            new CoursePlan(java.util.Arrays.asList("Variables", null));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

final class CoursePlan {

    private final List<String> lessons;

    CoursePlan(List<String> lessons) {
        if (lessons == null) {
            throw new IllegalArgumentException("Lessons are required.");
        }

        List<String> copy = new ArrayList<>(lessons);

        if (copy.contains(null)) {
            throw new IllegalArgumentException("Lessons cannot contain null.");
        }

        this.lessons = List.copyOf(copy);
    }

    List<String> getLessons() {
        return lessons;
    }
}
