// Generated from modules/04-inheritance-interfaces-and-polymorphism/06-interfaces-and-dependency-design.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson06.example02.notification;

public final class EmailNotificationSender
        implements NotificationSender {

    @Override
    public boolean send(String recipient, String message) {
        if (
                recipient == null
                || recipient.isBlank() || !recipient.contains("@")) {
            return false;
        }

        if (message == null || message.isBlank()) {
            return false;
        }

        System.out.println("Sending email...");

        System.out.println("Recipient: " + recipient);

        System.out.println("Message: " + message);

        return true;
    }
}
