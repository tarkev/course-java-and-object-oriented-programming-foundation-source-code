// Generated from modules/09-file-handling-and-i-o/07-designing-a-file-based-repository.md by tools/extract_code.py. Edit the lesson, not this file.
package module09.lesson07.example01.course;

public final class Course {

    private final CourseCode code;
    private final String title;
    private final long priceInPaisa;

    private CourseStatus status;

    public Course(
            CourseCode code,
            String title,
            long priceInPaisa
    ) {
        this(
                code,
                title,
                priceInPaisa,
                CourseStatus.DRAFT
        );
    }

    private Course(
            CourseCode code,
            String title,
            long priceInPaisa,
            CourseStatus status
    ) {
        if (
                code == null
        ) {
            throw new IllegalArgumentException(
                    "Course code is required."
            );
        }

        if (
                title == null
                || title.isBlank()
        ) {
            throw new IllegalArgumentException(
                    "Course title is required."
            );
        }

        if (
                priceInPaisa < 0
        ) {
            throw new IllegalArgumentException(
                    "Course price cannot be negative."
            );
        }

        if (
                status == null
        ) {
            throw new IllegalArgumentException(
                    "Course status is required."
            );
        }

        this.code =
                code;

        this.title =
                title.strip();

        this.priceInPaisa =
                priceInPaisa;

        this.status =
                status;
    }

    public static Course restore(
            CourseCode code,
            String title,
            long priceInPaisa,
            CourseStatus status
    ) {
        return new Course(
                code,
                title,
                priceInPaisa,
                status
        );
    }

    public void changeStatus(
            CourseStatus targetStatus
    ) {
        if (
                !status.canTransitionTo(
                        targetStatus
                )
        ) {
            throw new IllegalStateException(
                    "Invalid course status transition from "
                            + status
                            + " to "
                            + targetStatus
                            + "."
            );
        }

        status =
                targetStatus;
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
        return code
                + " — "
                + title
                + " — "
                + status;
    }
}
