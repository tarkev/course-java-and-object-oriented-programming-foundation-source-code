// Generated from modules/04-inheritance-interfaces-and-polymorphism/05-polymorphic-methods-and-collections.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson05.example01;

public class Main {

    public static void main(String[] args) {
        VideoLesson video = new VideoLesson(1L, "Polymorphic Methods",
                "https://cdn.tarkev.com/videos/methods", 18);

        ArticleLesson article = new ArticleLesson(2L, "Runtime Dispatch",
                1_000, "https://cdn.tarkev.com/articles/dispatch");

        QuizLesson quiz =
                new QuizLesson(3L, "Polymorphism Assessment", 10, 70);

        ContentItem[] contentItems = {video, article, quiz};

        int publishedCount = publishAll(contentItems);

        printSummaries(contentItems);

        System.out.println("Published items: " + publishedCount);

        System.out.println(
                "Total learning time: "
                + calculateTotalMinutes(contentItems) + " minutes");

        System.out.println();

        printDownload(video);

        printQuizResult(quiz, 8);
    }

    private static int publishAll(ContentItem[] contentItems) {
        int publishedCount = 0;

        for (ContentItem content : contentItems) {
            if (content.publish()) {
                publishedCount++;
            }
        }

        return publishedCount;
    }

    private static int calculateTotalMinutes(ContentItem[] contentItems) {
        int totalMinutes = 0;

        for (ContentItem content : contentItems) {
            totalMinutes += content.calculateEstimatedMinutes();
        }

        return totalMinutes;
    }

    private static void printSummaries(ContentItem[] contentItems) {
        for (ContentItem content : contentItems) {
            System.out.println(
                    content.getContentType() + ": " + content.getTitle());

            System.out.println(
                    "Estimated minutes: " + content.calculateEstimatedMinutes());

            System.out.println("Published: " + content.isPublished());

            System.out.println();
        }
    }

    private static void printDownload(Downloadable downloadable) {
        System.out.println("Download URL: " + downloadable.getDownloadUrl());
    }

    private static void printQuizResult(
            QuizLesson quiz, int correctAnswers) {
        System.out.println(
                "Quiz score: " + quiz.calculateScore(correctAnswers));

        System.out.println("Passed: " + quiz.hasPassed(correctAnswers));
    }
}
