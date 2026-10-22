package module05.lesson11.example09;

import java.util.List;

public class Main {

    static int calculateTotalMinutes(List<ContentItem> items) {
        int total = 0;
        for (ContentItem item : items) {
            if (item != null) {
                total += item.calculateEstimatedMinutes();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        List<ContentItem> items = List.of(
                new VideoLesson("Generics", 25),
                new ArticleLesson("Choosing Collections", 1200),
                new VideoLesson("Iterators", 15));
        System.out.println(calculateTotalMinutes(items));
    }
}

abstract class ContentItem {
    private final String title;

    protected ContentItem(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    abstract int calculateEstimatedMinutes();
}

final class VideoLesson extends ContentItem {
    private final int durationInMinutes;

    VideoLesson(String title, int durationInMinutes) {
        super(title);
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    int calculateEstimatedMinutes() {
        return durationInMinutes;
    }
}

final class ArticleLesson extends ContentItem {
    private static final int WORDS_PER_MINUTE = 200;
    private final int wordCount;

    ArticleLesson(String title, int wordCount) {
        super(title);
        this.wordCount = wordCount;
    }

    @Override
    int calculateEstimatedMinutes() {
        return wordCount / WORDS_PER_MINUTE;
    }
}
