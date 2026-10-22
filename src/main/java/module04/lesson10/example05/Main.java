package module04.lesson10.example05;

public class Main {

    public static void main(String[] args) {
        ContentItem[] contentItems = {
            new VideoLesson(1L, "Method Overriding"),
            new ArticleLesson(2L, "Runtime Polymorphism"),
            new QuizLesson(3L, "Overriding Assessment")
        };

        for (ContentItem content : contentItems) {
            System.out.println(
                    content.getContentType() + ": " + content.getTitle());
        }
    }
}

class ContentItem {

    private final String title;

    public ContentItem(long id, String title) {
        this.title = title;
    }

    public String getContentType() {
        return "CONTENT";
    }

    public String getTitle() {
        return title;
    }
}

class VideoLesson extends ContentItem {

    public VideoLesson(long id, String title) {
        super(id, title);
    }

    @Override
    public String getContentType() {
        return "VIDEO";
    }
}

class ArticleLesson extends ContentItem {

    public ArticleLesson(long id, String title) {
        super(id, title);
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}

class QuizLesson extends ContentItem {

    public QuizLesson(long id, String title) {
        super(id, title);
    }

    @Override
    public String getContentType() {
        return "QUIZ";
    }
}
