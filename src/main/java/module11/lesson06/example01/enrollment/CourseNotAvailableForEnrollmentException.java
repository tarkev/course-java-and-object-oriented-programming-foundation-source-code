package module11.lesson06.example01.enrollment;

import module11.lesson06.example01.course.CourseCode;

public final class CourseNotAvailableForEnrollmentException
        extends RuntimeException {

    public CourseNotAvailableForEnrollmentException(
            CourseCode courseCode) {
        super("Course is not available for enrollment: " + courseCode + ".");
    }
}
