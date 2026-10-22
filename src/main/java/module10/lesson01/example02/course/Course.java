package module10.lesson01.example02.course;

public final class Course {

    private final CourseCode code;
    private final String title;

    public Course(CourseCode code, String title) {
        if (code == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        this.code = code;
        this.title = title.strip();
    }

    public CourseCode getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
