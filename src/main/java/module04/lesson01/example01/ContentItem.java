// Generated from modules/04-inheritance-interfaces-and-polymorphism/01-introduction-to-inheritance.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson01.example01;

public class ContentItem {

    private final long id;
    private final String title;

    private boolean published;

    public ContentItem(long id, String title) {
        if (id <= 0) {
            throw new IllegalArgumentException("Content ID must be positive.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Content title is required.");
        }

        this.id = id;

        this.title = title.strip();

        this.published = false;
    }

    public boolean publish() {
        if (published) {
            return false;
        }

        published = true;

        return true;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPublished() {
        return published;
    }
}
