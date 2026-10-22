package module10.lesson11.tests.course;

public final class Course {

    private final CourseCode code;
    private final long priceInPaisa;

    private String title;
    private CourseStatus status;

    public Course(CourseCode code, String title, long priceInPaisa) {
        if (code == null) {
            throw new IllegalArgumentException("Course code is required.");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }
        if (priceInPaisa < 0) {
            throw new IllegalArgumentException(
                    "Course price cannot be negative.");
        }

        this.code = code;
        this.title = title.strip();
        this.priceInPaisa = priceInPaisa;
        this.status = CourseStatus.DRAFT;
    }

    public void changeTitle(String newTitle) {
        if (newTitle == null || newTitle.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }
        if (status == CourseStatus.PUBLISHED) {
            throw new IllegalStateException(
                    "Published course title cannot be changed.");
        }

        title = newTitle.strip();
    }

    public void publish() {
        if (status == CourseStatus.PUBLISHED) {
            throw new IllegalStateException("Course is already published.");
        }
        if (status != CourseStatus.DRAFT && status != CourseStatus.REVIEW) {
            throw new IllegalStateException(
                    "Course cannot be published from status " + status + ".");
        }
        if (title.length() < 3) {
            throw new IllegalStateException(
                    "Course title is too short for publication.");
        }

        status = CourseStatus.PUBLISHED;
    }

    public CourseSummary summary() {
        return new CourseSummary(code, title, priceInPaisa, status);
    }

    public CourseCode getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public long getPriceInPaisa() {
        return priceInPaisa;
    }

    public CourseStatus getStatus() {
        return status;
    }
}
