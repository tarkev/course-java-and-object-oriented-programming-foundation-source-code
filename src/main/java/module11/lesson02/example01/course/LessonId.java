package module11.lesson02.example01.course;

public record LessonId(long value) {

    public LessonId {
        if (value <= 0) {
            throw new IllegalArgumentException("Lesson id must be positive.");
        }
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
