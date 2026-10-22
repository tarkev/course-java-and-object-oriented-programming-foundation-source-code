package module04.lesson10.example02;

public class Main {

    public static void main(String[] args) {
        publishAndPrint(new VideoLesson(1L, "Introduction to Inheritance",
                "https://cdn.tarkev.com/videos/inheritance", 18));
        publishAndPrint(new ArticleLesson(2L, "Type Hierarchies",
                "A hierarchy models related types.", 7));
        publishAndPrint(new QuizLesson(3L, "Inheritance Quiz", 10, 70));
    }

    static void publishAndPrint(ContentItem content) {
        content.publish();

        System.out.println("Title: " + content.getTitle());
        System.out.println("Published: " + content.isPublished());
        System.out.println();
    }
}

class ContentItem {

    private final String title;

    private boolean published;

    public ContentItem(long id, String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Content title is required.");
        }

        this.title = title.strip();
    }

    public boolean publish() {
        if (published) {
            return false;
        }

        published = true;
        return true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPublished() {
        return published;
    }
}

class VideoLesson extends ContentItem {

    private final String videoUrl;
    private final int durationInMinutes;

    public VideoLesson(
            long id, String title, String videoUrl, int durationInMinutes) {
        super(id, title);
        this.videoUrl = videoUrl;
        this.durationInMinutes = durationInMinutes;
    }
}

class ArticleLesson extends ContentItem {

    private final String content;
    private final int estimatedReadingMinutes;

    public ArticleLesson(
            long id, String title, String content, int readingMinutes) {
        super(id, title);
        this.content = content;
        this.estimatedReadingMinutes = readingMinutes;
    }
}

class QuizLesson extends ContentItem {

    private final int questionCount;
    private final int passingScore;

    public QuizLesson(
            long id, String title, int questionCount, int passingScore) {
        super(id, title);
        this.questionCount = questionCount;
        this.passingScore = passingScore;
    }
}
