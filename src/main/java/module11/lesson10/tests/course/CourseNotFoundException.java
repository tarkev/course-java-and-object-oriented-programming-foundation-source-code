package module11.lesson10.tests.course;

public final class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(CourseCode courseCode) {
        super("Course not found: " + courseCode + ".");
    }
}
