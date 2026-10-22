package module03.lesson08.example01;

public class Enrollment {

    private final Learner learner;
    private final Course course;

    private int completedLessons;
    private boolean active;

    public Enrollment(Learner learner, Course course) {
        if (learner == null) {
            throw new IllegalArgumentException("Learner is required.");
        }

        if (course == null) {
            throw new IllegalArgumentException("Course is required.");
        }

        if (!course.isPublished()) {
            throw new IllegalArgumentException(
                    "Cannot enroll in an unpublished course.");
        }

        this.learner = learner;
        this.course = course;
        this.completedLessons = 0;
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

        if (updatedCount > course.getTotalLessons()) {
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

    public double calculateProgress() {
        return completedLessons * 100.0 / course.getTotalLessons();
    }

    public int calculateRemainingLessons() {
        return course.getTotalLessons() - completedLessons;
    }

    public boolean isCompleted() {
        return completedLessons == course.getTotalLessons();
    }

    public Learner getLearner() {
        return learner;
    }

    public Course getCourse() {
        return course;
    }

    public int getCompletedLessons() {
        return completedLessons;
    }

    public boolean isActive() {
        return active;
    }
}
