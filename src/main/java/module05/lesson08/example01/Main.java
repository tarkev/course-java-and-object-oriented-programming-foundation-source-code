// Generated from modules/05-generics-collections-and-core-data-structures/08-designing-classes-that-own-collections.md by tools/extract_code.py. Edit the lesson, not this file.
package module05.lesson08.example01;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Course course = new Course(1L, "Java and OOP Foundation");

        course.addLesson(new Lesson(101L, "Introduction to Generics"));

        course.addLesson(new Lesson(102L, "Working with List"));

        course.addLesson(new Lesson(103L, "Working with Set"));

        boolean duplicateAdded =
                course.addLesson(new Lesson(102L, "Duplicate Lesson"));

        course.renameLesson(103L, "Working with Set and Equality");

        course.moveLesson(103L, 1);

        printLessons(course);

        System.out.println("Duplicate added: " + duplicateAdded);

        System.out.println("Published: " + course.publish());

        System.out.println(
                "Can remove after publish: " + course.removeLesson(101L));
    }

    private static void printLessons(Course course) {
        List<Lesson> lessons = course.getLessons();

        for (int index = 0; index < lessons.size(); index++) {
            System.out.println(
                    (index + 1) + ". " + lessons.get(index).getTitle());
        }
    }
}
