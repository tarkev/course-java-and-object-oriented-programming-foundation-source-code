package module04.lesson08.example01.progress;

import module04.lesson08.example01.content.ContentItem;

public final class LearnerProgress {

    private final String learnerName;
    private final ContentItem content;
    private final CompletionPolicy completionPolicy;

    private int progressPercentage;

    public LearnerProgress(String learnerName, ContentItem content,
            CompletionPolicy completionPolicy) {
        if (learnerName == null || learnerName.isBlank()) {
            throw new IllegalArgumentException("Learner name is required.");
        }

        if (content == null) {
            throw new IllegalArgumentException("Content is required.");
        }

        if (completionPolicy == null) {
            throw new IllegalArgumentException("Completion policy is required.");
        }

        this.learnerName = learnerName.strip();
        this.content = content;
        this.completionPolicy = completionPolicy;
        this.progressPercentage = 0;
    }

    public boolean updateProgress(int newProgressPercentage) {
        if (newProgressPercentage < 0 || newProgressPercentage > 100) {
            return false;
        }

        if (newProgressPercentage < progressPercentage) {
            return false;
        }

        progressPercentage = newProgressPercentage;
        return true;
    }

    public boolean isCompleted() {
        return completionPolicy.isCompleted(progressPercentage);
    }

    public String createSummary() {
        return learnerName + " completed " + progressPercentage + "% of "
                + content.getTitle() + ". " + completionPolicy.getDescription() + ".";
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public ContentItem getContent() {
        return content;
    }
}
