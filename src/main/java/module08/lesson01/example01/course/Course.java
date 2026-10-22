package module08.lesson01.example01.course;

public final class Course {

    private final long id;
    private final String title;

    private CourseStatus status;

    public Course(long id, String title) {
        if (id <= 0) {
            throw new IllegalArgumentException("Course ID must be positive.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        this.id = id;
        this.title = title.strip();
        this.status = CourseStatus.DRAFT;
    }

    public boolean submitForReview() {
        if (status != CourseStatus.DRAFT) {
            return false;
        }

        status = CourseStatus.REVIEW;
        return true;
    }

    public boolean returnToDraft() {
        if (status != CourseStatus.REVIEW) {
            return false;
        }

        status = CourseStatus.DRAFT;
        return true;
    }

    public boolean publish() {
        if (status != CourseStatus.REVIEW) {
            return false;
        }

        status = CourseStatus.PUBLISHED;
        return true;
    }

    public boolean archive() {
        if (status != CourseStatus.PUBLISHED) {
            return false;
        }

        status = CourseStatus.ARCHIVED;
        return true;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public boolean isEditable() {
        return status.isEditable();
    }

    public boolean isPubliclyVisible() {
        return status.isPubliclyVisible();
    }
}
