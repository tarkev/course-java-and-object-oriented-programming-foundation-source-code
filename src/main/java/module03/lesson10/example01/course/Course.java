// Generated from modules/03-object-oriented-programming-foundations/10-packages-and-organizing-java-code.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson10.example01.course;

public class Course {

    private final CourseCode code;
    private final String title;
    private final int totalLessons;

    private boolean published;

    public Course(CourseCode code, String title, int totalLessons) {
        if (code == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (totalLessons <= 0) {
            throw new IllegalArgumentException(
                    "Total lessons must be greater than zero.");
        }

        this.code = code;

        this.title = title.strip();

        this.totalLessons = totalLessons;

        this.published = false;
    }

    public boolean publish() {
        if (published) {
            return false;
        }

        published = true;

        return true;
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

    public boolean isPublished() {
        return published;
    }
}
