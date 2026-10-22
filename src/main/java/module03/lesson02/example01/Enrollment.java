// Generated from modules/03-object-oriented-programming-foundations/02-classes-objects-fields-and-methods.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson02.example01;

public class Enrollment {

    String learnerName;
    String courseTitle;

    int completedLessons;
    int totalLessons;

    void completeLesson() {
        if (totalLessons <= 0 || completedLessons >= totalLessons) {
            return;
        }

        completedLessons++;
    }

    double calculateProgress() {
        if (totalLessons <= 0) {
            return 0.0;
        }

        return completedLessons * 100.0 / totalLessons;
    }

    boolean isCompleted() {
        return totalLessons > 0 && completedLessons == totalLessons;
    }
}
