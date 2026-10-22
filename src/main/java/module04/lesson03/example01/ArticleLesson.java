// Generated from modules/04-inheritance-interfaces-and-polymorphism/03-method-overriding-and-runtime-polymorphism.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson03.example01;

public class ArticleLesson
        extends ContentItem {

    private static final int WORDS_PER_MINUTE = 200;

    private final int wordCount;

    public ArticleLesson(long id, String title, int wordCount) {
        super(id, title);

        if (wordCount <= 0) {
            throw new IllegalArgumentException("Word count must be positive.");
        }

        this.wordCount = wordCount;
    }

    @Override
    public int calculateEstimatedMinutes() {
        int estimatedMinutes = wordCount / WORDS_PER_MINUTE;

        return Math.max(1, estimatedMinutes);
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}
