package module04.lesson01.example01;

public class Main {

    public static void main(String[] args) {
        VideoLesson videoLesson =
                new VideoLesson(1L, "Introduction to Inheritance",
                        "https://cdn.tarkev.com/videos/inheritance",
                        18);

        ArticleLesson articleLesson =
                new ArticleLesson(
                        2L,
                        "Understanding Type Hierarchies",
                        "A hierarchy models related types.", 7);

        videoLesson.publish();
        articleLesson.publish();

        printSummary(videoLesson);
        printSummary(articleLesson);
    }

    private static void printSummary(ContentItem content) {
        System.out.println("ID: " + content.getId());
        System.out.println("Title: " + content.getTitle());
        System.out.println("Published: " + content.isPublished());
        System.out.println();
    }
}
