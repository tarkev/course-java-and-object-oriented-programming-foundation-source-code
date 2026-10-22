// Generated from modules/04-inheritance-interfaces-and-polymorphism/03-method-overriding-and-runtime-polymorphism.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson03.example01;

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

    public int calculateEstimatedMinutes() {
        return 0;
    }

    public String getContentType() {
        return "CONTENT";
    }

    public boolean publish() {
        if (published) {
            return false;
        }

        published = true;

        return true;
    }

    public final long getId() {
        return id;
    }

    public final String getTitle() {
        return title;
    }

    public final boolean isPublished() {
        return published;
    }
}
