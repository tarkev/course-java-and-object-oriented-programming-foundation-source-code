package module04.lesson11.example03.content;

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

    protected abstract boolean isReadyForPublication();

    public final boolean publish() {
        if (published) {
            return false;
        }

        if (!isReadyForPublication()) {
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

    @Override
    public String toString() {
        return "ContentItem{id=" + id + ", title='" + title + "', type="
                + getContentType() + ", estimatedMinutes="
                + calculateEstimatedMinutes() + ", published=" + published + '}';
    }
}
