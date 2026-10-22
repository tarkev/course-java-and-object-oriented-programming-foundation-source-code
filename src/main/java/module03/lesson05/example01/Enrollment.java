// Generated from modules/03-object-oriented-programming-foundations/05-encapsulation-access-control-and-object-invariants.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson05.example01;

public class Enrollment {

    private String learnerName;
    private String courseTitle;

    private int completedLessons;
    private int totalLessons;

    private boolean active;

    public Enrollment(
            String learnerName, String courseTitle, int totalLessons) {
        if (learnerName == null || learnerName.isBlank()) {
            throw new IllegalArgumentException("Learner name is required.");
        }

        if (courseTitle == null || courseTitle.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (totalLessons <= 0) {
            throw new IllegalArgumentException(
                    "Total lessons must be greater than zero.");
        }

        this.learnerName = learnerName.strip();

        this.courseTitle = courseTitle.strip();

        this.completedLessons = 0;

        this.totalLessons = totalLessons;

        this.active = true;
    }

    public boolean completeLessons(int lessonCount) {
        if (!active) {
            return false;
        }

        if (lessonCount <= 0) {
            return false;
        }

        int updatedCount = completedLessons + lessonCount;

        if (updatedCount > totalLessons) {
            return false;
        }

        completedLessons = updatedCount;

        return true;
    }

    public boolean cancel() {
        if (!active) {
            return false;
        }

        if (isCompleted()) {
            return false;
        }

        active = false;

        return true;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getCompletedLessons() {
        return completedLessons;
    }

    public int getTotalLessons() {
        return totalLessons;
    }

    public int calculateRemainingLessons() {
        return totalLessons - completedLessons;
    }

    public double calculateProgress() {
        return completedLessons * 100.0 / totalLessons;
    }

    public boolean isCompleted() {
        return completedLessons == totalLessons;
    }

    public boolean isActive() {
        return active;
    }
}
