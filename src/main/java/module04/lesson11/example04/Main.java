package module04.lesson11.example04;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        VideoResource video = new VideoResource(1L, "Polymorphism in Practice",
                "https://cdn.tarkev.com/videos/practice", 15);
        DocumentResource document = new DocumentResource(2L,
                "Interface Cheat Sheet", 4,
                "https://cdn.tarkev.com/docs/interfaces.pdf");
        AssessmentResource assessment =
                new AssessmentResource(3L, "Module 4 Assessment", 12, 75);

        LearningResource[] resources = {video, document, assessment};
        ResourceCatalog catalog = new ResourceCatalog(resources);

        System.out.println("Published: " + catalog.publishAll());
        System.out.println(
                "Total minutes: " + catalog.calculateTotalMinutes());
        catalog.printDownloads();
        System.out.println("Assessment score: " + assessment.calculateScore(9));
        System.out.println("Assessment passed: " + assessment.hasPassed(9));

        ResourceNotifier notifier =
                new ResourceNotifier(new ConsoleNotificationSender());
        notifier.notifyPublication(video, "samiul@example.com");
    }
}

abstract class LearningResource {

    private final long id;
    private final String title;

    private boolean published;

    protected LearningResource(long id, String title) {
        if (id <= 0) {
            throw new IllegalArgumentException("Resource ID must be positive.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Resource title is required.");
        }

        this.id = id;
        this.title = title.strip();
    }

    public abstract int calculateEstimatedMinutes();

    public abstract String getResourceType();

    public final boolean publish() {
        if (published) {
            return false;
        }

        published = true;
        return true;
    }

    public final long getId() {
        return id;
    }

    public final String getTitle() {
        return title;
    }

    public final boolean isPublished() {
        return published;
    }
}

interface Downloadable {

    String getDownloadUrl();
}

interface Gradable {

    int calculateScore(int correctAnswers);

    boolean hasPassed(int correctAnswers);
}

final class VideoResource extends LearningResource implements Downloadable {

    private final String videoUrl;
    private final int durationInMinutes;

    public VideoResource(
            long id, String title, String videoUrl, int durationInMinutes) {
        super(id, title);

        if (videoUrl == null || videoUrl.isBlank()) {
            throw new IllegalArgumentException("Video URL is required.");
        }

        if (durationInMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be positive.");
        }

        this.videoUrl = videoUrl.strip();
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public int calculateEstimatedMinutes() {
        return durationInMinutes;
    }

    @Override
    public String getResourceType() {
        return "VIDEO";
    }

    @Override
    public String getDownloadUrl() {
        return videoUrl;
    }
}

final class DocumentResource extends LearningResource
        implements Downloadable {

    private static final int MINUTES_PER_PAGE = 3;

    private final int pageCount;
    private final String downloadUrl;

    public DocumentResource(
            long id, String title, int pageCount, String downloadUrl) {
        super(id, title);

        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be positive.");
        }

        if (downloadUrl == null || downloadUrl.isBlank()) {
            throw new IllegalArgumentException("Download URL is required.");
        }

        this.pageCount = pageCount;
        this.downloadUrl = downloadUrl.strip();
    }

    @Override
    public int calculateEstimatedMinutes() {
        return pageCount * MINUTES_PER_PAGE;
    }

    @Override
    public String getResourceType() {
        return "DOCUMENT";
    }

    @Override
    public String getDownloadUrl() {
        return downloadUrl;
    }
}

final class AssessmentResource extends LearningResource
        implements Gradable {

    private static final int MINUTES_PER_QUESTION = 2;

    private final int questionCount;
    private final int passingScore;

    public AssessmentResource(
            long id, String title, int questionCount, int passingScore) {
        super(id, title);

        if (questionCount <= 0) {
            throw new IllegalArgumentException(
                    "Question count must be positive.");
        }

        if (passingScore < 0 || passingScore > 100) {
            throw new IllegalArgumentException(
                    "Passing score must be between 0 and 100.");
        }

        this.questionCount = questionCount;
        this.passingScore = passingScore;
    }

    @Override
    public int calculateEstimatedMinutes() {
        return questionCount * MINUTES_PER_QUESTION;
    }

    @Override
    public String getResourceType() {
        return "ASSESSMENT";
    }

    @Override
    public int calculateScore(int correctAnswers) {
        if (correctAnswers < 0 || correctAnswers > questionCount) {
            throw new IllegalArgumentException(
                    "Correct answer count is invalid.");
        }

        return correctAnswers * 100 / questionCount;
    }

    @Override
    public boolean hasPassed(int correctAnswers) {
        return calculateScore(correctAnswers) >= passingScore;
    }
}

final class ResourceCatalog {

    private final LearningResource[] resources;

    public ResourceCatalog(LearningResource[] resources) {
        if (resources == null) {
            throw new IllegalArgumentException("Resources are required.");
        }

        for (LearningResource resource : resources) {
            if (resource == null) {
                throw new IllegalArgumentException(
                        "Resources cannot contain null.");
            }
        }

        this.resources = Arrays.copyOf(resources, resources.length);
    }

    public int publishAll() {
        int publishedCount = 0;

        for (LearningResource resource : resources) {
            if (resource.publish()) {
                publishedCount++;
            }
        }

        return publishedCount;
    }

    public int calculateTotalMinutes() {
        int totalMinutes = 0;

        for (LearningResource resource : resources) {
            totalMinutes += resource.calculateEstimatedMinutes();
        }

        return totalMinutes;
    }

    public void printDownloads() {
        for (LearningResource resource : resources) {
            if (resource instanceof Downloadable downloadable) {
                System.out.println(resource.getResourceType() + ": "
                        + downloadable.getDownloadUrl());
            }
        }
    }
}

interface NotificationSender {

    boolean send(String recipient, String message);
}

final class ConsoleNotificationSender implements NotificationSender {

    @Override
    public boolean send(String recipient, String message) {
        System.out.println(recipient + " → " + message);
        return true;
    }
}

final class ResourceNotifier {

    private final NotificationSender sender;

    public ResourceNotifier(NotificationSender sender) {
        if (sender == null) {
            throw new IllegalArgumentException(
                    "Notification sender is required.");
        }

        this.sender = sender;
    }

    public boolean notifyPublication(
            LearningResource resource, String recipient) {
        if (resource == null || !resource.isPublished()) {
            return false;
        }

        return sender.send(recipient,
                resource.getResourceType() + " published: "
                + resource.getTitle());
    }
}
