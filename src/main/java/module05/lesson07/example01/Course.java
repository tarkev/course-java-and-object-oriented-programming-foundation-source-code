// Generated from modules/05-generics-collections-and-core-data-structures/07-iteration-and-collection-operations.md by tools/extract_code.py. Edit the lesson, not this file.
package module05.lesson07.example01;

public final class Course {

    private final long id;
    private final String title;
    private final String difficulty;
    private final long priceInPaisa;

    private boolean published;

    public Course(long id, String title, String difficulty,
            long priceInPaisa, boolean published) {
        if (id <= 0) {
            throw new IllegalArgumentException("Course ID must be positive.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (difficulty == null || difficulty.isBlank()) {
            throw new IllegalArgumentException("Difficulty is required.");
        }

        if (priceInPaisa < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        this.id = id;

        this.title = title.strip();

        this.difficulty = difficulty.strip().toUpperCase();

        this.priceInPaisa = priceInPaisa;

        this.published = published;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public long getPriceInPaisa() {
        return priceInPaisa;
    }

    public boolean isPublished() {
        return published;
    }
}
