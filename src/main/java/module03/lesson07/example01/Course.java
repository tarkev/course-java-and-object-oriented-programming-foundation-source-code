package module03.lesson07.example01;

import java.util.Objects;

public class Course {

    private final String code;

    private String title;
    private boolean published;

    public Course(String code, String title) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Course code is required.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        this.code = code.strip().toUpperCase();
        this.title = title.strip();
        this.published = false;
    }

    public boolean changeTitle(String newTitle) {
        if (newTitle == null || newTitle.isBlank()) {
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

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPublished() {
        return published;
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
        return "Course{"
                + "code='" + code + '\''
                + ", title='" + title + '\''
                + ", published=" + published + '}';
    }
}
