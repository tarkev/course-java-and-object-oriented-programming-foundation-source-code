// Generated from modules/03-object-oriented-programming-foundations/03-constructors-and-valid-object-creation.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson03.example01;

public class Main {

    public static void main(String[] args) {
        Enrollment enrollment =
                new Enrollment("Nur", "Java and OOP Foundation", 20);

        enrollment.completeLesson();
        enrollment.completeLesson();

        System.out.println("Learner: " + enrollment.learnerName);

        System.out.println("Course: " + enrollment.courseTitle);

        System.out.println(
                "Progress: " + enrollment.calculateProgress() + "%");

        System.out.println(
                "Remaining: " + enrollment.calculateRemainingLessons());
    }
}
