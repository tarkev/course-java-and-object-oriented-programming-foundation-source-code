package module11.lesson06.example01.course;

public final class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(CourseCode courseCode) {
        super("Course not found: " + courseCode + ".");
    }
}
