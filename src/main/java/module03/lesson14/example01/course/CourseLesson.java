package module03.lesson14.example01.course;

import java.util.Objects;

public final class CourseLesson {

    private final String id;
    private final String title;
    private final int minutes;

    public CourseLesson(String id, String title, int minutes) {
        if (id == null || id.isBlank() || title == null || title.isBlank()) {
            throw new IllegalArgumentException("ID and title are required.");
        }

        if (minutes <= 0) {
            throw new IllegalArgumentException(
                    "Minutes must be greater than zero.");
        }

        this.id = id.strip();
        this.title = title.strip();
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        CourseLesson lesson = (CourseLesson) other;

        return id.equals(lesson.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
