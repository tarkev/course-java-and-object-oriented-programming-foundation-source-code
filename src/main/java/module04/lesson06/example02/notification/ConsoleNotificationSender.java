// Generated from modules/04-inheritance-interfaces-and-polymorphism/06-interfaces-and-dependency-design.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson06.example02.notification;

public final class ConsoleNotificationSender
        implements NotificationSender {

    @Override
    public boolean send(String recipient, String message) {
        if (recipient == null || recipient.isBlank()) {
            return false;
        }

        if (message == null || message.isBlank()) {
            return false;
        }

        System.out.println("[Console Notification]");

        System.out.println(recipient + " → " + message);

        return true;
    }
}
