package module11.lesson06.example01.enrollment;

import module11.lesson06.example01.course.CourseCode;
import module11.lesson06.example01.learner.LearnerId;

public record EnrollmentSummary(EnrollmentId id, LearnerId learnerId,
        CourseCode courseCode, EnrollmentStatus status) {

    public EnrollmentSummary {
        if (id == null) {
            throw new IllegalArgumentException("Enrollment id is required.");
        }

        if (learnerId == null) {
            throw new IllegalArgumentException("Learner id is required.");
        }

        if (courseCode == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        if (status == null) {
            throw new IllegalArgumentException("Enrollment status is required.");
        }
    }
}
