package module11.lesson06.example01.enrollment;

import module11.lesson06.example01.course.CourseCode;
import module11.lesson06.example01.learner.LearnerId;

public final class DuplicateEnrollmentException extends RuntimeException {

    public DuplicateEnrollmentException(
            LearnerId learnerId, CourseCode courseCode) {
        super("Learner " + learnerId + " is already enrolled in course "
                + courseCode + ".");
    }
}
