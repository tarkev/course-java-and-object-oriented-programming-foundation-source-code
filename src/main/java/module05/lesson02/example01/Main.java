// Generated from modules/05-generics-collections-and-core-data-structures/02-working-with-list.md by tools/extract_code.py. Edit the lesson, not this file.
package module05.lesson02.example01;

public class Main {

    public static void main(String[] args) {
        Course course = new Course(1L, "Java and OOP Foundation");

        course.addLesson("Introduction to Java");

        course.addLesson("Classes and Objects");

        course.addLesson("Inheritance");

        course.renameLesson(2, "Inheritance and Polymorphism");

        course.printLessons();

        System.out.println("Lesson count: " + course.getLessonCount());

        System.out.println("Published: " + course.publish());

        System.out.println(
                "Can add after publish: " + course.addLesson("Generics"));

        System.out.println("Lessons: " + course.getLessonTitles());
    }
}
