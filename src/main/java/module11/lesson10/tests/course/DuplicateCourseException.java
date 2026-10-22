package module11.lesson10.tests.course;

public final class DuplicateCourseException extends RuntimeException {

    public DuplicateCourseException(CourseCode courseCode) {
        super("Course already exists: " + courseCode + ".");
    }
}
