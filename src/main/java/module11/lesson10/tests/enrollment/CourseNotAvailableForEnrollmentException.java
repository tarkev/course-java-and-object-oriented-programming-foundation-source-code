package module11.lesson10.tests.enrollment;

import module11.lesson10.tests.course.CourseCode;

public final class CourseNotAvailableForEnrollmentException extends RuntimeException {

    public CourseNotAvailableForEnrollmentException(
            CourseCode courseCode) {
        super("Course is not available for enrollment: " + courseCode + ".");
    }
}
