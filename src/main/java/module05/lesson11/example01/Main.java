package module05.lesson11.example01;

public class Main {
    public static void main(String[] args) {
        Container<String> learner = new Container<>("Subu");
        learner.replaceValue("Sumu");
        System.out.println(learner.getValue());

        Container<Course> course = new Container<>(new Course("Java Basics"));
        System.out.println(course.getValue().getTitle());

        Container<ContentItem> content = new Container<>(new VideoLesson("Generics"));
        content.replaceValue(new VideoLesson("Wildcards"));
        System.out.println(content.getValue().getTitle());
    }
}

final class Container<T> {
    private T value;

    Container(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    void replaceValue(T value) {
        this.value = value;
    }
}

final class Course {
    private final String title;

    Course(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }
}

interface ContentItem {
    String getTitle();
}

final class VideoLesson implements ContentItem {
    private final String title;

    VideoLesson(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
