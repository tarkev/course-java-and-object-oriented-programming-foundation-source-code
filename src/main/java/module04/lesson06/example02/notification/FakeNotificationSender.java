// Generated from modules/04-inheritance-interfaces-and-polymorphism/06-interfaces-and-dependency-design.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson06.example02.notification;

public final class FakeNotificationSender
        implements NotificationSender {

    private String lastRecipient;
    private String lastMessage;
    private int sendCount;

    @Override
    public boolean send(String recipient, String message) {
        lastRecipient = recipient;

        lastMessage = message;

        sendCount++;

        return true;
    }

    public String getLastRecipient() {
        return lastRecipient;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public int getSendCount() {
        return sendCount;
    }
}
