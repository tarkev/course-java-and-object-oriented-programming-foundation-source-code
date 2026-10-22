package module07.lesson15.example02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        List<String> lessons = new ArrayList<>(List.of("Lambdas", "Streams"));
        CourseOutline outline = new CourseOutline("Modern Java", lessons);

        lessons.add("Records");

        System.out.println(lessons);
        System.out.println(outline.lessonTitles());
    }

    record CourseOutline(String title, List<String> lessonTitles) {

        CourseOutline {
            title = Objects.requireNonNull(title, "Title is required.").strip();
            if (title.isBlank()) {
                throw new IllegalArgumentException("Title is required.");
            }
            lessonTitles = List.copyOf(lessonTitles);
        }
    }
}
