// Generated from modules/05-generics-collections-and-core-data-structures/07-iteration-and-collection-operations.md by tools/extract_code.py. Edit the lesson, not this file.
package module05.lesson07.example01;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course(1L, "Java and OOP Foundation", "BEGINNER", 499_000L, true),
                new Course(2L, "Backend Development", "INTERMEDIATE", 899_000L, true),
                new Course(3L, "System Design", "ADVANCED", 1_299_000L, false),
                new Course(4L, "Programming Basics", "BEGINNER", 0L, true));

        List<Course> publishedCourses =
                CourseOperations.findPublishedCourses(courses);

        System.out.println("Published titles:");

        for (String title : CourseOperations.extractTitles(publishedCourses)) {
            System.out.println(title);
        }

        System.out.println(
                "Total price: " + CourseOperations.calculateTotalPrice(courses));

        Course mostExpensive = CourseOperations.findMostExpensive(courses);

        if (mostExpensive != null) {
            System.out.println("Most expensive: " + mostExpensive.getTitle());
        }

        Map<String, Integer> counts =
                CourseOperations.countByDifficulty(courses);

        System.out.println("Difficulty counts: " + counts);
    }
}
