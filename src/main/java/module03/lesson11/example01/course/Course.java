package module03.lesson11.example01.course;

import java.util.Objects;

public class Course {

    public static final int MAX_TITLE_LENGTH = 150;

    private static int totalCoursesCreated;

    private final CourseCode code;
    private final int totalLessons;
    private final long priceInPaisa;

    private String title;
    private boolean published;

    public Course(CourseCode code, String title, int totalLessons) {
        this(code, title, totalLessons, 0);
    }

    public Course(
            CourseCode code, String title, int totalLessons, long priceInPaisa) {
        if (code == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        validateTitle(title);

        if (totalLessons <= 0) {
            throw new IllegalArgumentException(
                    "Total lessons must be greater than zero.");
        }

        if (priceInPaisa < 0) {
            throw new IllegalArgumentException(
                    "Course price cannot be negative.");
        }

        this.code = code;
        this.title = title.strip();
        this.totalLessons = totalLessons;
        this.priceInPaisa = priceInPaisa;
        this.published = false;

        totalCoursesCreated++;
    }

    public boolean changeTitle(String newTitle) {
        if (published) {
            return false;
        }

        if (!isValidTitle(newTitle)) {
            return false;
        }

        title = newTitle.strip();
        return true;
    }

    public boolean publish() {
        if (published) {
            return false;
        }

        published = true;
        return true;
    }

    public boolean isFree() {
        return priceInPaisa == 0;
    }

    public CourseCode getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getTotalLessons() {
        return totalLessons;
    }

    public long getPriceInPaisa() {
        return priceInPaisa;
    }

    public boolean isPublished() {
        return published;
    }

    public static int getTotalCoursesCreated() {
        return totalCoursesCreated;
    }

    private static void validateTitle(String title) {
        if (!isValidTitle(title)) {
            throw new IllegalArgumentException(
                    "Course title is required and cannot exceed "
                    + MAX_TITLE_LENGTH + " characters.");
        }
    }

    private static boolean isValidTitle(String title) {
        return title != null && !title.isBlank()
                && title.strip().length() <= MAX_TITLE_LENGTH;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Course course = (Course) other;
        return code.equals(course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", title='" + title + '\''
                + ", totalLessons=" + totalLessons
                + ", priceInPaisa=" + priceInPaisa
                + ", published=" + published + '}';
    }
}
