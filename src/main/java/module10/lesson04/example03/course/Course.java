package module10.lesson04.example03.course;

public final class Course {

    private final CourseCode code;
    private String title;
    private CourseStatus status;

    public Course(CourseCode code, String title) {
        if (code == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        this.code = code;
        this.title = requireTitle(title);
        this.status = CourseStatus.DRAFT;
    }

    public void changeTitle(String newTitle) {
        title = requireTitle(newTitle);
    }

    public void publish() {
        if (status != CourseStatus.DRAFT) {
            throw new IllegalStateException("Only draft courses can be published.");
        }

        status = CourseStatus.PUBLISHED;
    }

    public CourseSummary summary() {
        return new CourseSummary(code, title, status);
    }

    private static String requireTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        return title.strip();
    }
}
