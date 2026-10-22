package module04.lesson11.example03.content;

public final class AudioLesson extends ContentItem implements Downloadable {

    private final String audioUrl;
    private final int durationInMinutes;

    public AudioLesson(
            long id, String title, String audioUrl, int durationInMinutes) {
        super(id, title);

        if (audioUrl == null || audioUrl.isBlank()) {
            throw new IllegalArgumentException("Audio URL is required.");
        }

        if (durationInMinutes <= 0) {
            throw new IllegalArgumentException(
                    "Audio duration must be positive.");
        }

        this.audioUrl = audioUrl.strip();
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

    @Override
    protected boolean isReadyForPublication() {
        return audioUrl.startsWith("https://");
    }

    @Override
    public String getDownloadUrl() {
        return audioUrl;
    }
}
