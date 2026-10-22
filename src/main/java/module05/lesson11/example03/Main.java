package module05.lesson11.example03;

public class Main {

    static <T> T choose(T first, T second, boolean chooseSecond) {
        if (chooseSecond) {
            return second;
        }
        return first;
    }

    public static void main(String[] args) {
        String learner = choose("Nur", "Subu", true);
        Integer score = choose(72, 95, false);
        VideoLesson lesson = choose(new VideoLesson("Generics"),
                new VideoLesson("Wildcards"), true);

        System.out.println(learner);
        System.out.println(score);
        System.out.println(lesson.getTitle());
    }
}

final class VideoLesson {
    private final String title;

    VideoLesson(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }
}
