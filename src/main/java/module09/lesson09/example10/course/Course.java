package module09.lesson09.example10.course;

public final class Course {

    private final CourseCode code;
    private final String title;
    private final long priceInPaisa;
    private CourseStatus status;

    public Course(CourseCode code, String title, long priceInPaisa) {
        this(code, title, priceInPaisa, CourseStatus.DRAFT);
    }

    private Course(CourseCode code, String title, long priceInPaisa,
            CourseStatus status) {
        if (code == null || status == null) {
            throw new IllegalArgumentException(
                    "Course code and status are required.");
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
        this.status = status;
    }

    public static Course restore(CourseCode code, String title,
            long priceInPaisa, CourseStatus status) {
        return new Course(code, title, priceInPaisa, status);
    }

    public void changeStatus(CourseStatus targetStatus) {
        if (!status.canTransitionTo(targetStatus)) {
            throw new IllegalStateException("Invalid course status "
                    + "transition from " + status + " to " + targetStatus);
        }

        status = targetStatus;
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

    @Override
    public String toString() {
        return code + " — " + title + " — " + status;
    }
}
