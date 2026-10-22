package module04.lesson05.example01;

public final class VideoLesson extends ContentItem implements Downloadable {

    private final String videoUrl;
    private final int durationInMinutes;

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

    @Override
    public int calculateEstimatedMinutes() {
        return durationInMinutes;
    }

    @Override
    public String getContentType() {
        return "VIDEO";
    }

    @Override
    public String getDownloadUrl() {
        return videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}
