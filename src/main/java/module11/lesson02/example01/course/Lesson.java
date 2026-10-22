package module11.lesson02.example01.course;

public record Lesson(LessonId id, String title, String content) {

    public Lesson {
        if (id == null) {
            throw new IllegalArgumentException("Lesson id is required.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Lesson title is required.");
        }

        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Lesson content is required.");
        }

        title = title.strip();
        content = content.strip();
    }
}
