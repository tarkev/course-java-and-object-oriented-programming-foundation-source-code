package module04.lesson06.example01;

public class Main {

    public static void main(String[] args) {
        NotificationSender sender = new EmailNotificationSender();
        EnrollmentNotifier notifier = new EnrollmentNotifier(sender);

        notifier.notifyEnrollment(
                "nur@example.com", "Nur", "Java and OOP Foundation");
    }
}
