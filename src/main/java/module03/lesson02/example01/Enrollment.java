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
