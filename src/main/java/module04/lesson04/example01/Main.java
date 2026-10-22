package module04.lesson04.example01;

public class Main {

    public static void main(String[] args) {
        VideoLesson video = new VideoLesson(1L, "Abstract Classes",
                "https://cdn.tarkev.com/videos/abstract", 18);
        ArticleLesson article = new ArticleLesson(2L, "Interfaces", 1_000,
                "https://cdn.tarkev.com/articles/interfaces.pdf");
        QuizLesson quiz =
                new QuizLesson(3L, "Abstraction Assessment", 10, 70);

        video.publish();
        article.publish();
        quiz.publish();

        printContent(video);
        printContent(article);
        printContent(quiz);
        printDownload(video);
        printDownload(article);
        printGrade(quiz, 8);
    }

    private static void printContent(ContentItem content) {
        System.out.println(
                content.getContentType() + ": " + content.getTitle());
        System.out.println(
                "Estimated minutes: " + content.calculateEstimatedMinutes());
        System.out.println("Published: " + content.isPublished());
        System.out.println();
    }

    private static void printDownload(Downloadable downloadable) {
        System.out.println("Download URL: " + downloadable.getDownloadUrl());
        System.out.println();
    }

    private static void printGrade(
            Gradable gradable, int correctAnswers) {
        System.out.println(
                "Score: " + gradable.calculateScore(correctAnswers));
        System.out.println("Passed: " + gradable.hasPassed(correctAnswers));
    }
}
