package module11.lesson10.tests.enrollment;

import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.learner.LearnerId;

public final class DuplicateEnrollmentException extends RuntimeException {

    public DuplicateEnrollmentException(
            LearnerId learnerId, CourseCode courseCode) {
        super("Learner " + learnerId + " is already enrolled in course "
                + courseCode + ".");
    }
}
