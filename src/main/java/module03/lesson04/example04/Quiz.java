package module03.lesson04.example04;

public class Quiz {

    String title;
    int questionCount;

    Quiz(String title) {
        this(title, 10);
        System.out.println("Short constructor finished");
    }

    Quiz(String title, int questionCount) {
        System.out.println("Primary constructor: " + title);
        this.title = title;
        this.questionCount = questionCount;
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz("Java Basics");
        System.out.println(quiz.questionCount);
    }
}
