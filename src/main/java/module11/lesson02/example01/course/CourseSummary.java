package module11.lesson02.example01.course;

public record CourseSummary(CourseCode code, String title,
        long priceInPaisa, CourseStatus status, int lessonCount) {

    public CourseSummary {
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

        if (status == null) {
            throw new IllegalArgumentException("Course status is required.");
        }

        if (lessonCount < 0) {
            throw new IllegalArgumentException(
                    "Lesson count cannot be negative.");
        }

        title = title.strip();
    }
}
