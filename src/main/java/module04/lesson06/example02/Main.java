package module04.lesson06.example02;

import module04.lesson06.example02.enrollment.EnrollmentNotifier;
import module04.lesson06.example02.notification.ConsoleNotificationSender;
import module04.lesson06.example02.notification.EmailNotificationSender;
import module04.lesson06.example02.notification.FakeNotificationSender;
import module04.lesson06.example02.notification.NotificationSender;

public class Main {

    public static void main(String[] args) {
        sendWithEmail();
        sendWithConsole();
        verifyWithFake();
    }

    private static void sendWithEmail() {
        NotificationSender sender = new EmailNotificationSender();
        EnrollmentNotifier notifier = new EnrollmentNotifier(sender);

        boolean sent =
                notifier.notifyEnrollment(
                        "nur@example.com", "Nur", "Java and OOP Foundation");

        System.out.println("Email sent: " + sent);
        System.out.println();
    }

    private static void sendWithConsole() {
        NotificationSender sender = new ConsoleNotificationSender();
        EnrollmentNotifier notifier = new EnrollmentNotifier(sender);

        boolean sent =
                notifier.notifyEnrollment(
                        "subu@example.com", "Subu", "Backend Development");

        System.out.println("Console notification sent: " + sent);
        System.out.println();
    }

    private static void verifyWithFake() {
        FakeNotificationSender sender = new FakeNotificationSender();
        EnrollmentNotifier notifier = new EnrollmentNotifier(sender);

        boolean sent =
                notifier.notifyEnrollment(
                        "sumu@example.com", "Sumu", "System Design");

        System.out.println("Fake result: " + sent);
        System.out.println("Send count: " + sender.getSendCount());
        System.out.println(
                "Captured recipient: " + sender.getLastRecipient());
        System.out.println("Captured message: " + sender.getLastMessage());
    }
}
