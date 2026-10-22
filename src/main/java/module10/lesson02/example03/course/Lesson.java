package module10.lesson02.example03.course;

public record Lesson(long id, String title) {

    public Lesson {
        if (id <= 0) {
            throw new IllegalArgumentException("Lesson id must be positive.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Lesson title is required.");
        }

        title = title.strip();
    }
}
