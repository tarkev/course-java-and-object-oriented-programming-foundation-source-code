// Generated from modules/04-inheritance-interfaces-and-polymorphism/08-project-polymorphic-content-system.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson08.example01.notification;

import module04.lesson08.example01.content.ContentItem;

public final class ContentPublicationNotifier {

    private final NotificationSender sender;

    public ContentPublicationNotifier(NotificationSender sender) {
        if (sender == null) {
            throw new IllegalArgumentException(
                    "Notification sender is required.");
        }

        this.sender = sender;
    }

    public boolean notifyPublication(
            ContentItem content, String recipient) {
        if (content == null) {
            return false;
        }

        if (recipient == null || recipient.isBlank()) {
            return false;
        }

        if (!content.isPublished()) {
            return false;
        }

        String message =
                content.getContentType() + " published: " + content.getTitle();

        return sender.send(recipient.strip(), message);
    }
}
