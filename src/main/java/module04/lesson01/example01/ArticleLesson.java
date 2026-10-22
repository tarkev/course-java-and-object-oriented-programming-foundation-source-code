package module04.lesson01.example01;

public class ArticleLesson
        extends ContentItem {

    private final String content;
    private final int estimatedReadingMinutes;

    public ArticleLesson(
            long id, String title, String content, int estimatedReadingMinutes) {
        super(id, title);

        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Article content is required.");
        }

        if (estimatedReadingMinutes <= 0) {
            throw new IllegalArgumentException("Reading time must be positive.");
        }

        this.content = content.strip();
        this.estimatedReadingMinutes = estimatedReadingMinutes;
    }

    public String getContent() {
        return content;
    }

    public int getEstimatedReadingMinutes() {
        return estimatedReadingMinutes;
    }
}
