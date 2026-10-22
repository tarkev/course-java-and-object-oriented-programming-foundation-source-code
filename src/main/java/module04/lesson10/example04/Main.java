package module04.lesson10.example04;

public class Main {

    public static void main(String[] args) {
        ContentItem quiz = new QuizLesson(3L, "Overriding Quiz", 10);
        System.out.println(
                "Estimated minutes: " + quiz.calculateEstimatedMinutes());
    }
}

class ContentItem {

    private final String title;

    public ContentItem(long id, String title) {
        this.title = title;
    }

    public int calculateEstimatedMinutes() {
        return 0;
    }

    public String getTitle() {
        return title;
    }
}

class QuizLesson extends ContentItem {

    private static final int MINUTES_PER_QUESTION = 3;

    private final int questionCount;

    public QuizLesson(long id, String title, int questionCount) {
        super(id, title);

        if (questionCount <= 0) {
            throw new IllegalArgumentException(
                    "Question count must be positive.");
        }

        this.questionCount = questionCount;
    }

    @Override
    public int calculateEstimatedMinutes() {
        return questionCount * MINUTES_PER_QUESTION;
    }
}
