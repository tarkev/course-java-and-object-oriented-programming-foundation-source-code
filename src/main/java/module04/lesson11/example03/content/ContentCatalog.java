package module04.lesson11.example03.content;

import java.util.Arrays;

public final class ContentCatalog {

    private final ContentItem[] contentItems;

    public ContentCatalog(ContentItem[] contentItems) {
        if (contentItems == null) {
            throw new IllegalArgumentException("Content items are required.");
        }

        for (ContentItem content : contentItems) {
            if (content == null) {
                throw new IllegalArgumentException(
                        "Content items cannot contain null.");
            }
        }

        this.contentItems = Arrays.copyOf(contentItems, contentItems.length);
    }

    public int publishAll() {
        int publishedCount = 0;

        for (ContentItem content : contentItems) {
            if (content.publish()) {
                publishedCount++;
            }
        }

        return publishedCount;
    }

    public int calculateTotalMinutes() {
        int totalMinutes = 0;

        for (ContentItem content : contentItems) {
            totalMinutes += content.calculateEstimatedMinutes();
        }

        return totalMinutes;
    }

    public void printSummaries() {
        for (ContentItem content : contentItems) {
            System.out.println(
                    content.getContentType() + ": " + content.getTitle());
            System.out.println(
                    "Estimated minutes: " + content.calculateEstimatedMinutes());
            System.out.println("Published: " + content.isPublished());
            System.out.println();
        }
    }

    public void printDownloads() {
        for (ContentItem content : contentItems) {
            if (content instanceof Downloadable downloadable) {
                System.out.println(content.getTitle());
                System.out.println(downloadable.getDownloadUrl());
                System.out.println();
            }
        }
    }

    public ContentItem[] getContentItems() {
        return Arrays.copyOf(contentItems, contentItems.length);
    }
}
