package module04.lesson05.example01;

public abstract class ContentItem {

    private final long id;
    private final String title;

    private boolean published;

    protected ContentItem(long id, String title) {
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

    public abstract int calculateEstimatedMinutes();

    public abstract String getContentType();

    public final boolean publish() {
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
