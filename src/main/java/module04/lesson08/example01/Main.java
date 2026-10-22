package module04.lesson08.example01;

import module04.lesson08.example01.content.ArticleLesson;
import module04.lesson08.example01.content.ContentCatalog;
import module04.lesson08.example01.content.ContentItem;
import module04.lesson08.example01.content.QuizLesson;
import module04.lesson08.example01.content.VideoLesson;
import module04.lesson08.example01.notification.ContentPublicationNotifier;
import module04.lesson08.example01.notification.FakeNotificationSender;
import module04.lesson08.example01.progress.FullCompletionPolicy;
import module04.lesson08.example01.progress.LearnerProgress;
import module04.lesson08.example01.progress.ThresholdCompletionPolicy;

public class Main {

    public static void main(String[] args) {
        VideoLesson video = new VideoLesson(1L, "Runtime Polymorphism",
                "https://cdn.tarkev.com/videos/polymorphism", 18);
        ArticleLesson article = new ArticleLesson(2L,
                "Programming to Interfaces", 1_200,
                "https://cdn.tarkev.com/articles/interfaces.pdf");
        QuizLesson quiz =
                new QuizLesson(3L, "Inheritance Assessment", 10, 70);

        ContentItem[] contentItems = {video, article, quiz};
        ContentCatalog catalog = new ContentCatalog(contentItems);
        int publishedCount = catalog.publishAll();

        catalog.printSummaries();
        System.out.println("Published items: " + publishedCount);
        System.out.println(
                "Total learning time: "
                + catalog.calculateTotalMinutes() + " minutes");
        System.out.println();
        System.out.println("Available downloads:");
        catalog.printDownloads();

        printQuizResult(quiz, 8);
        demonstrateCompletionPolicies(video, article);
        verifyPublicationNotification(video);
    }

    private static void printQuizResult(
            QuizLesson quiz, int correctAnswers) {
        System.out.println(
                "Quiz score: " + quiz.calculateScore(correctAnswers));
        System.out.println("Quiz passed: " + quiz.hasPassed(correctAnswers));
        System.out.println();
    }

    private static void demonstrateCompletionPolicies(
            VideoLesson video, ArticleLesson article) {
        LearnerProgress videoProgress =
                new LearnerProgress("Subu", video, new FullCompletionPolicy());
        LearnerProgress articleProgress =
                new LearnerProgress(
                        "Sumu", article, new ThresholdCompletionPolicy(80));

        videoProgress.updateProgress(90);
        articleProgress.updateProgress(80);

        System.out.println(videoProgress.createSummary());
        System.out.println("Completed: " + videoProgress.isCompleted());
        System.out.println();
        System.out.println(articleProgress.createSummary());
        System.out.println("Completed: " + articleProgress.isCompleted());
        System.out.println();
    }

    private static void verifyPublicationNotification(VideoLesson video) {
        FakeNotificationSender sender = new FakeNotificationSender();
        ContentPublicationNotifier notifier =
                new ContentPublicationNotifier(sender);
        boolean notified =
                notifier.notifyPublication(video, "nur@example.com");

        System.out.println("Notification sent: " + notified);
        System.out.println("Send count: " + sender.getSendCount());
        System.out.println(
                "Captured recipient: " + sender.getLastRecipient());
        System.out.println("Captured message: " + sender.getLastMessage());
    }
}
