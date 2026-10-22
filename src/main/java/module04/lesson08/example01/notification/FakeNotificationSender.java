package module04.lesson08.example01.notification;

public final class FakeNotificationSender implements NotificationSender {

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
