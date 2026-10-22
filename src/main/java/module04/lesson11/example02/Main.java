package module04.lesson11.example02;

public class Main {

    public static void main(String[] args) {
        NotificationSender sender = new SmsNotificationSender();
        EnrollmentNotifier notifier = new EnrollmentNotifier(sender);

        boolean sent = notifier.notifyEnrollment(
                "+8801700000000", "Subu", "Java and OOP Foundation");

        System.out.println("SMS sent: " + sent);
    }
}

interface NotificationSender {

    boolean send(String recipient, String message);
}

final class SmsNotificationSender implements NotificationSender {

    @Override
    public boolean send(String recipient, String message) {
        if (recipient == null || recipient.isBlank()) {
            return false;
        }

        if (message == null || message.isBlank()) {
            return false;
        }

        System.out.println("Sending SMS to " + recipient);
        System.out.println("Message: " + message);
        return true;
    }
}

final class EnrollmentNotifier {

    private final NotificationSender sender;

    public EnrollmentNotifier(NotificationSender sender) {
        if (sender == null) {
            throw new IllegalArgumentException(
                    "Notification sender is required.");
        }

        this.sender = sender;
    }

    public boolean notifyEnrollment(
            String learnerEmail, String learnerName, String courseTitle) {
        if (learnerEmail == null || learnerEmail.isBlank()) {
            return false;
        }

        if (learnerName == null || learnerName.isBlank()) {
            return false;
        }

        if (courseTitle == null || courseTitle.isBlank()) {
            return false;
        }

        String message =
                "Hello "
                + learnerName.strip()
                + ", you are now enrolled in " + courseTitle.strip() + ".";

        return sender.send(learnerEmail.strip(), message);
    }
}
