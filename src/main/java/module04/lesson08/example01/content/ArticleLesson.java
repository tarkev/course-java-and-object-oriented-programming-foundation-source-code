// Generated from modules/04-inheritance-interfaces-and-polymorphism/08-project-polymorphic-content-system.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson08.example01.content;

public final class ArticleLesson extends ContentItem
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
            throw new IllegalArgumentException(
                    "Article download URL is required.");
        }

        this.wordCount = wordCount;

        this.downloadUrl = downloadUrl.strip();
    }

    @Override
    public int calculateEstimatedMinutes() {
        return (wordCount + WORDS_PER_MINUTE - 1) / WORDS_PER_MINUTE;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    protected boolean isReadyForPublication() {
        return wordCount >= 100 && downloadUrl.startsWith("https://");
    }

    @Override
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public int getWordCount() {
        return wordCount;
    }
}
