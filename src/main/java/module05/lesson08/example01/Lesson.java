// Generated from modules/05-generics-collections-and-core-data-structures/08-designing-classes-that-own-collections.md by tools/extract_code.py. Edit the lesson, not this file.
package module05.lesson08.example01;

public final class Lesson {

    private final long id;
    private final String title;

    public Lesson(long id, String title) {
        if (id <= 0) {
            throw new IllegalArgumentException("Lesson ID must be positive.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Lesson title is required.");
        }

        this.id = id;

        this.title = title.strip();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Lesson rename(String newTitle) {
        return new Lesson(id, newTitle);
    }

    @Override
    public String toString() {
        return id + ": " + title;
    }
}
