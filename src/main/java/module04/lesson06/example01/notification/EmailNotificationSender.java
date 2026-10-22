package module04.lesson06.example01.notification;

public final class EmailNotificationSender implements NotificationSender {

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
