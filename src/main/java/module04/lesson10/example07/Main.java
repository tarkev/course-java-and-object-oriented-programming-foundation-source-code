package module04.lesson10.example07;

public class Main {

    public static void main(String[] args) {
        VideoLesson video = new VideoLesson(1L, "Abstract Classes",
                "https://cdn.tarkev.com/videos/abstract");
        QuizLesson quiz = new QuizLesson(2L, "Abstraction Quiz", 10, 70);

        printDownload(video);
        printGrade(quiz, 8);
    }

    static void printDownload(Downloadable downloadable) {
        System.out.println("Download URL: " + downloadable.getDownloadUrl());
    }

    static void printGrade(Gradable gradable, int correctAnswers) {
        System.out.println(
                "Score: " + gradable.calculateScore(correctAnswers));
    }
}

abstract class ContentItem {

    private final String title;

    protected ContentItem(long id, String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

interface Downloadable {

    String getDownloadUrl();
}

interface Gradable {

    int calculateScore(int correctAnswers);

    boolean hasPassed(int correctAnswers);
}

class VideoLesson extends ContentItem implements Downloadable {

    private final String videoUrl;

    public VideoLesson(long id, String title, String videoUrl) {
        super(id, title);
        this.videoUrl = videoUrl;
    }

    @Override
    public String getDownloadUrl() {
        return videoUrl;
    }
}

class QuizLesson extends ContentItem implements Gradable {

    private final int questionCount;
    private final int passingScore;

    public QuizLesson(
            long id, String title, int questionCount, int passingScore) {
        super(id, title);
        this.questionCount = questionCount;
        this.passingScore = passingScore;
    }

    @Override
    public int calculateScore(int correctAnswers) {
        return correctAnswers * 100 / questionCount;
    }

    @Override
    public boolean hasPassed(int correctAnswers) {
        return calculateScore(correctAnswers) >= passingScore;
    }
}
