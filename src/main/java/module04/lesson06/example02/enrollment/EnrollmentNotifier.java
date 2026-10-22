// Generated from modules/04-inheritance-interfaces-and-polymorphism/06-interfaces-and-dependency-design.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson06.example02.enrollment;

import module04.lesson06.example02.notification.NotificationSender;

public final class EnrollmentNotifier {

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
