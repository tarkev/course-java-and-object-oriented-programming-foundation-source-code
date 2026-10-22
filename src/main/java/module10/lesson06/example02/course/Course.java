package module10.lesson06.example02.course;

public final class Course {

    private final CourseCode code;
    private final String title;
    private boolean published;

    public Course(CourseCode code, String title) {
        this.code = code;
        this.title = title;
    }

    public void publish() {
        published = true;
    }

    public CourseCode getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPublished() {
        return published;
    }
}
