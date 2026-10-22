// Generated from modules/04-inheritance-interfaces-and-polymorphism/08-project-polymorphic-content-system.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson08.example01.content;

public final class VideoLesson extends ContentItem
        implements Downloadable {

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
    protected boolean isReadyForPublication() {
        return videoUrl.startsWith("https://");
    }

    @Override
    public String getDownloadUrl() {
        return videoUrl;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}
