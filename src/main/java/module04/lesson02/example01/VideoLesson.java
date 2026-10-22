package module04.lesson02.example01;

public class VideoLesson
        extends ContentItem {

    private final String videoUrl;
    private final int durationInMinutes;

    public VideoLesson(long id, String title, String videoUrl) {
        this(id, title, videoUrl, 1);
    }

    public VideoLesson(
            long id, String title, String videoUrl, int durationInMinutes) {
        super(id, title);

        if (videoUrl == null || videoUrl.isBlank()) {
            throw new IllegalArgumentException("Video URL is required.");
        }

        if (durationInMinutes <= 0) {
            throw new IllegalArgumentException(
                    "Video duration must be positive.");
        }

        this.videoUrl = videoUrl.strip();
        this.durationInMinutes = durationInMinutes;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}
