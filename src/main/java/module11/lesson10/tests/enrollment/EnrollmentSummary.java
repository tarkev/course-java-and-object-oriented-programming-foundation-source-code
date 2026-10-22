package module11.lesson10.tests.enrollment;

import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.learner.LearnerId;

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
