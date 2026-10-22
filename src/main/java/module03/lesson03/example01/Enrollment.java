// Generated from modules/03-object-oriented-programming-foundations/03-constructors-and-valid-object-creation.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson03.example01;

public class Enrollment {

    String learnerName;
    String courseTitle;

    int completedLessons;
    int totalLessons;

    Enrollment(
            String initialLearnerName,
            String initialCourseTitle, int initialTotalLessons) {
        if (initialLearnerName == null || initialLearnerName.isBlank()) {
            throw new IllegalArgumentException("Learner name is required.");
        }

        if (initialCourseTitle == null || initialCourseTitle.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (initialTotalLessons <= 0) {
            throw new IllegalArgumentException(
                    "Total lessons must be greater than zero.");
        }

        learnerName = initialLearnerName.strip();

        courseTitle = initialCourseTitle.strip();

        completedLessons = 0;

        totalLessons = initialTotalLessons;
    }

    void completeLesson() {
        if (completedLessons >= totalLessons) {
            return;
        }

        completedLessons++;
    }

    int calculateRemainingLessons() {
        return totalLessons - completedLessons;
    }

    double calculateProgress() {
        return completedLessons * 100.0 / totalLessons;
    }

    boolean isCompleted() {
        return completedLessons == totalLessons;
    }
}
