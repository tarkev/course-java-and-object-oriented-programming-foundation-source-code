package module04.lesson10.example01;

public class Main {

    public static void main(String[] args) {
        QuizLesson quiz = new QuizLesson(3L, "Inheritance Quiz", 10, 70);
        quiz.publish();

        System.out.println("Title: " + quiz.getTitle());
        System.out.println("Questions: " + quiz.getQuestionCount());
        System.out.println("Passing score: " + quiz.getPassingScore());
        System.out.println("Published: " + quiz.isPublished());
    }
}

class ContentItem {

    private final long id;
    private final String title;

    private boolean published;

    public ContentItem(long id, String title) {
        if (id <= 0) {
            throw new IllegalArgumentException("Content ID must be positive.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Content title is required.");
        }

        this.id = id;
        this.title = title.strip();
        this.published = false;
    }

    public boolean publish() {
        if (published) {
            return false;
        }

        published = true;
        return true;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPublished() {
        return published;
    }
}

class QuizLesson extends ContentItem {

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

    public int getQuestionCount() {
        return questionCount;
    }

    public int getPassingScore() {
        return passingScore;
    }
}
