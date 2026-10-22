package module04.lesson11.example03;

import module04.lesson11.example03.content.AudioLesson;
import module04.lesson11.example03.content.ContentCatalog;
import module04.lesson11.example03.content.ContentItem;
import module04.lesson11.example03.content.Gradable;
import module04.lesson11.example03.content.QuizLesson;
import module04.lesson11.example03.content.VideoLesson;

public class Main {

    public static void main(String[] args) {
        VideoLesson video = new VideoLesson(1L, "Runtime Polymorphism",
                "https://cdn.tarkev.com/videos/polymorphism", 18);
        AudioLesson audio = new AudioLesson(2L, "Interfaces on the Go",
                "https://cdn.tarkev.com/audio/interfaces", 25);
        QuizLesson quiz =
                new QuizLesson(3L, "Inheritance Assessment", 10, 70);

        ContentItem[] contentItems = {video, audio, quiz};
        ContentCatalog catalog = new ContentCatalog(contentItems);

        System.out.println("Published items: " + catalog.publishAll());
        System.out.println(
                "Total learning time: "
                + catalog.calculateTotalMinutes() + " minutes");
        System.out.println();
        catalog.printDownloads();
        printGrade(quiz, 8);
    }

    static void printGrade(Gradable gradable, int correctAnswers) {
        System.out.println("Score: " + gradable.calculateScore(correctAnswers));
        System.out.println("Passed: " + gradable.hasPassed(correctAnswers));
    }
}
