package module10.lesson07.example01.course;

public final class DuplicateCourseException extends RuntimeException {

    public DuplicateCourseException(CourseCode courseCode) {
        super("Course already exists: " + courseCode + ".");
    }
}
