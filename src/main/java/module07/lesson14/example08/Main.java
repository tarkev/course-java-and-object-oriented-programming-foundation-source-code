package module07.lesson14.example08;

public class Main {

    sealed interface LessonContent permits VideoContent, ArticleContent, QuizContent {
    }

    record VideoContent(String title, int minutes) implements LessonContent {
    }

    record ArticleContent(String title, int words) implements LessonContent {
    }

    record QuizContent(String title, int questions) implements LessonContent {
    }

    static int studyMinutes(LessonContent content) {
        return switch (content) {
            case VideoContent video -> video.minutes();
            case ArticleContent article -> article.words() / 200;
            case QuizContent quiz -> quiz.questions() * 2;
        };
    }

    public static void main(String[] args) {
        System.out.println(studyMinutes(new VideoContent("Streams in Practice", 18)));
        System.out.println(studyMinutes(new ArticleContent("Reading Records", 1_200)));
        System.out.println(studyMinutes(new QuizContent("Optional Quiz", 5)));
    }
}
