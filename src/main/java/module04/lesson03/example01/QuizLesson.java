package module04.lesson03.example01;

public class QuizLesson
        extends ContentItem {

    private static final int MINUTES_PER_QUESTION = 2;

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

    @Override
    public String getContentType() {
        return "QUIZ";
    }
}
