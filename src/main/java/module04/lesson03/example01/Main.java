// Generated from modules/04-inheritance-interfaces-and-polymorphism/03-method-overriding-and-runtime-polymorphism.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson03.example01;

public class Main {

    public static void main(String[] args) {
        ContentItem video = new VideoLesson(1L, "Method Overriding",
                "https://cdn.tarkev.com/videos/overriding", 18);

        ContentItem article =
                new ArticleLesson(2L, "Runtime Polymorphism", 1_200);

        ContentItem quiz = new QuizLesson(3L, "Overriding Assessment", 10);

        printEstimate(video);

        printEstimate(article);

        printEstimate(quiz);
    }

    private static void printEstimate(ContentItem content) {
        System.out.println("Type: " + content.getContentType());

        System.out.println("Title: " + content.getTitle());

        System.out.println(
                "Estimated time: "
                + content.calculateEstimatedMinutes() + " minutes");

        System.out.println();
    }
}
