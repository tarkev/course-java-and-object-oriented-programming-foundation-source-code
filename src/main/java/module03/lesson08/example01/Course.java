package module03.lesson08.example01;

public class Course {

    private final String code;
    private final String title;
    private final int totalLessons;

    private boolean published;

    public Course(String code, String title, int totalLessons) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Course code is required.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (totalLessons <= 0) {
            throw new IllegalArgumentException(
                    "Total lessons must be greater than zero.");
        }

        this.code = code.strip().toUpperCase();
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

    public String getCode() {
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
