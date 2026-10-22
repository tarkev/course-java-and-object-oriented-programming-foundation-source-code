// Generated from modules/03-object-oriented-programming-foundations/10-packages-and-organizing-java-code.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson10.example01.enrollment;

import module03.lesson10.example01.course.Course;
import module03.lesson10.example01.learner.Learner;

public class Enrollment {

    private final Learner learner;
    private final Course course;

    private int completedLessons;

    public Enrollment(Learner learner, Course course) {
        if (learner == null) {
            throw new IllegalArgumentException("Learner is required.");
        }

        if (course == null) {
            throw new IllegalArgumentException("Course is required.");
        }

        if (!course.isPublished()) {
            throw new IllegalArgumentException("Course must be published.");
        }

        this.learner = learner;

        this.course = course;

        this.completedLessons = 0;
    }

    public boolean completeLessons(int lessonCount) {
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

    public double calculateProgress() {
        return completedLessons * 100.0 / course.getTotalLessons();
    }

    public Learner getLearner() {
        return learner;
    }

    public Course getCourse() {
        return course;
    }
}
