package module04.lesson08.example01.content;

public final class QuizLesson extends ContentItem implements Gradable {

    private static final int MINUTES_PER_QUESTION = 2;

    private final int questionCount;
    private final int passingScore;

    public QuizLesson(
            long id, String title, int questionCount, int passingScore) {
        super(id, title);

        if (questionCount <= 0) {
            throw new IllegalArgumentException(
                    "Question count must be positive.");
        }

        if (passingScore < 0 || passingScore > 100) {
            throw new IllegalArgumentException(
                    "Passing score must be between 0 and 100.");
        }

        this.questionCount = questionCount;
        this.passingScore = passingScore;
    }

    @Override
    public int calculateEstimatedMinutes() {
        return questionCount * MINUTES_PER_QUESTION;
    }

    @Override
    public String getContentType() {
        return "QUIZ";
    }

    @Override
    protected boolean isReadyForPublication() {
        return questionCount > 0;
    }

    @Override
    public int calculateScore(int correctAnswers) {
        validateCorrectAnswers(correctAnswers);
        return correctAnswers * 100 / questionCount;
    }

    @Override
    public boolean hasPassed(int correctAnswers) {
        return calculateScore(correctAnswers) >= passingScore;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public int getPassingScore() {
        return passingScore;
    }

    private void validateCorrectAnswers(int correctAnswers) {
        if (correctAnswers < 0 || correctAnswers > questionCount) {
            throw new IllegalArgumentException(
                    "Correct answer count is invalid.");
        }
    }
}
