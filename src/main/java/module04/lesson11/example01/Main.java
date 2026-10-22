package module04.lesson11.example01;

public class Main {

    public static void main(String[] args) {
        ContentItem[] contentItems = {
            new VideoLesson(1L, "Polymorphic Methods", 18),
            new AudioLesson(2L, "Polymorphism Podcast", 25)
        };

        int publishedCount = publishAll(contentItems);
        printSummaries(contentItems);

        System.out.println("Published items: " + publishedCount);
        System.out.println(
                "Total learning time: "
                + calculateTotalMinutes(contentItems) + " minutes");
    }

    private static int publishAll(ContentItem[] contentItems) {
        int publishedCount = 0;

        for (ContentItem content : contentItems) {
            if (content.publish()) {
                publishedCount++;
            }
        }

        return publishedCount;
    }

    private static int calculateTotalMinutes(ContentItem[] contentItems) {
        int totalMinutes = 0;

        for (ContentItem content : contentItems) {
            totalMinutes += content.calculateEstimatedMinutes();
        }

        return totalMinutes;
    }

    private static void printSummaries(ContentItem[] contentItems) {
        for (ContentItem content : contentItems) {
            System.out.println(
                    content.getContentType() + ": " + content.getTitle());
            System.out.println(
                    "Estimated minutes: " + content.calculateEstimatedMinutes());
            System.out.println("Published: " + content.isPublished());
            System.out.println();
        }
    }
}

abstract class ContentItem {

    private final String title;

    private boolean published;

    protected ContentItem(long id, String title) {
        this.title = title;
    }

    public abstract int calculateEstimatedMinutes();

    public abstract String getContentType();

    public final boolean publish() {
        if (published) {
            return false;
        }

        published = true;
        return true;
    }

    public final String getTitle() {
        return title;
    }

    public final boolean isPublished() {
        return published;
    }
}

final class VideoLesson extends ContentItem {

    private final int durationInMinutes;

    public VideoLesson(long id, String title, int durationInMinutes) {
        super(id, title);
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public int calculateEstimatedMinutes() {
        return durationInMinutes;
    }

    @Override
    public String getContentType() {
        return "VIDEO";
    }
}

final class AudioLesson extends ContentItem {

    private final int durationInMinutes;

    public AudioLesson(long id, String title, int durationInMinutes) {
        super(id, title);

        if (durationInMinutes <= 0) {
            throw new IllegalArgumentException(
                    "Audio duration must be positive.");
        }

        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public int calculateEstimatedMinutes() {
        return durationInMinutes;
    }

    @Override
    public String getContentType() {
        return "AUDIO";
    }
}
