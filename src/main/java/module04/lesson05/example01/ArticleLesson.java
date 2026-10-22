package module04.lesson05.example01;

public final class ArticleLesson extends ContentItem implements Downloadable {

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
