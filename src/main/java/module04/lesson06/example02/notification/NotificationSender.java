// Generated from modules/04-inheritance-interfaces-and-polymorphism/06-interfaces-and-dependency-design.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson06.example02.notification;

public interface NotificationSender {

    boolean send(String recipient, String message);
}
