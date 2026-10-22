package module04.lesson06.example01.notification;

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
