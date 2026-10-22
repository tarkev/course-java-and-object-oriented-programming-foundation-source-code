package module05.lesson01.example01;

import java.util.ArrayList;
import java.util.List;

interface ContentItem {
    String getTitle();
}

class VideoLesson implements ContentItem {
    private final String title;

    VideoLesson(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}

public class Main {

    static <T extends Comparable<T>> T max(List<T> items) {
        T best = null;
        for (T item : items) {
            if (best == null || item.compareTo(best) > 0) {
                best = item;
            }
        }
        return best;
    }

    static void printTitles(List<? extends ContentItem> items) {
        for (ContentItem item : items) {
            System.out.println(item.getTitle());
        }
    }

    static void addPassingScore(List<? super Integer> scores) {
        scores.add(50);
    }

    public static void main(String[] args) {
        System.out.println(max(List.of("Nur", "Subu", "Jalisa")));
        System.out.println(max(List.of(72, 95, 88)));

        List<VideoLesson> videos = List.of(
                new VideoLesson("Generics Basics"),
                new VideoLesson("Wildcards"));
        printTitles(videos);

        List<Number> numbers = new ArrayList<>();
        addPassingScore(numbers);
        System.out.println(numbers);
    }
}
