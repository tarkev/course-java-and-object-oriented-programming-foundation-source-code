package module10.lesson09.tests.course;

import java.util.Objects;

public record CourseSummary(
        CourseCode code, String title, long priceInPaisa, CourseStatus status) {

    public CourseSummary {
        Objects.requireNonNull(code, "Course code is required.");
        Objects.requireNonNull(title, "Course title is required.");
        Objects.requireNonNull(status, "Course status is required.");
    }
}
