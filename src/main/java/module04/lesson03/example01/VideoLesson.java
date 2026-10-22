// Generated from modules/04-inheritance-interfaces-and-polymorphism/03-method-overriding-and-runtime-polymorphism.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson03.example01;

public class VideoLesson
        extends ContentItem {

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

    public String getVideoUrl() {
        return videoUrl;
    }
}
