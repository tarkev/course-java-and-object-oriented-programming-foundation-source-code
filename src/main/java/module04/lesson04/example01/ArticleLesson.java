// Generated from modules/04-inheritance-interfaces-and-polymorphism/04-abstract-classes-and-interfaces.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson04.example01;

public final class ArticleLesson
        extends ContentItem
        implements Downloadable {

    private static final int WORDS_PER_MINUTE = 200;

    private final int wordCount;
    private final String downloadUrl;

    public ArticleLesson(
            long id, String title, int wordCount, String downloadUrl) {
        super(id, title);

        if (wordCount <= 0) {
            throw new IllegalArgumentException("Word count must be positive.");
        }

        if (downloadUrl == null || downloadUrl.isBlank()) {
            throw new IllegalArgumentException("Download URL is required.");
        }

        this.wordCount = wordCount;

        this.downloadUrl = downloadUrl.strip();
    }

    @Override
    public int calculateEstimatedMinutes() {
        return Math.max(1, wordCount / WORDS_PER_MINUTE);
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getDownloadUrl() {
        return downloadUrl;
    }
}
