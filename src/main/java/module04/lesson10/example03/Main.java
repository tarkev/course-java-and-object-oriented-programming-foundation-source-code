package module04.lesson10.example03;

public class Main {

    public static void main(String[] args) {
        new LiveVideoLesson(1L, "Live Q&A");
    }
}

class ContentItem {

    public ContentItem(long id, String title) {
        System.out.println("ContentItem constructor");
    }
}

class VideoLesson extends ContentItem {

    public VideoLesson(long id, String title) {
        super(id, title);
        System.out.println("VideoLesson constructor");
    }
}

class LiveVideoLesson extends VideoLesson {

    public LiveVideoLesson(long id, String title) {
        super(id, title);
        System.out.println("LiveVideoLesson constructor");
    }
}
