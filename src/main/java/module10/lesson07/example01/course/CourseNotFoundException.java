package module10.lesson07.example01.course;

public final class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(CourseCode courseCode) {
        super("Course not found: " + courseCode + ".");
    }
}
