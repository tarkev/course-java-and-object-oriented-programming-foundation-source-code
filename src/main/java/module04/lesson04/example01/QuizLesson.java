// Generated from modules/04-inheritance-interfaces-and-polymorphism/04-abstract-classes-and-interfaces.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson04.example01;

public final class QuizLesson
        extends ContentItem
        implements Gradable {

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
    public int calculateScore(int correctAnswers) {
        if (correctAnswers < 0 || correctAnswers > questionCount) {
            throw new IllegalArgumentException(
                    "Correct answer count is invalid.");
        }

        return correctAnswers * 100 / questionCount;
    }

    @Override
    public boolean hasPassed(int correctAnswers) {
        return calculateScore(correctAnswers) >= passingScore;
    }
}
