package module04.lesson11.example04;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DiskSpaceAlert disk = new DiskSpaceAlert(1L, " server-1 ", 8);
        FailedLoginAlert login = new FailedLoginAlert(2L, "vpn", "nur", 5);
        BackupAlert backup = new BackupAlert(3L, "server-1", "nightly", 120);
        Alert[] alerts = {disk, login, backup};

        AlertDispatcher offline =
                new AlertDispatcher(new OfflineAlertChannel(), alerts);
        System.out.println("Sent while offline: " + offline.sendAll());

        AlertDispatcher dispatcher =
                new AlertDispatcher(new ConsoleAlertChannel(), alerts);
        System.out.println("Sent: " + dispatcher.sendAll());
        System.out.println("Sent again: " + dispatcher.sendAll());
        System.out.println("Resend disk alert: " + dispatcher.send(disk));
        System.out.println("Disk alert sent: " + disk.isSent());
    }
}

abstract class Alert {

    private final long id;
    private final String source;
    private boolean sent;

    protected Alert(long id, String source) {
        if (id <= 0) {
            throw new IllegalArgumentException("Alert ID must be positive.");
        }

        if (source == null || source.isBlank()) {
            throw new IllegalArgumentException("Alert source is required.");
        }

        this.id = id;
        this.source = source.strip();
    }

    public abstract String getLevel();

    protected abstract String buildDetail();

    public final String render() {
        return "[" + getLevel() + "] " + source + ": " + buildDetail();
    }

    public final boolean markSent() {
        if (sent) {
            return false;
        }

        sent = true;
        return true;
    }

    public final long getId() {
        return id;
    }

    public final boolean isSent() {
        return sent;
    }
}

interface Fixable {

    String suggestFix();
}

final class DiskSpaceAlert extends Alert implements Fixable {

    private final int freePercent;

    public DiskSpaceAlert(long id, String source, int freePercent) {
        super(id, source);

        if (freePercent < 0 || freePercent > 100) {
            throw new IllegalArgumentException(
                    "Free space must be between 0 and 100.");
        }

        this.freePercent = freePercent;
    }

    @Override
    public String getLevel() {
        return "WARNING";
    }

    @Override
    protected String buildDetail() {
        return "only " + freePercent + "% disk space left";
    }

    @Override
    public String suggestFix() {
        return "delete old log files";
    }
}

final class FailedLoginAlert extends Alert implements Fixable {

    private final String username;
    private final int attemptCount;

    public FailedLoginAlert(
            long id, String source, String username, int attemptCount) {
        super(id, source);

        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username is required.");
        }

        if (attemptCount <= 0) {
            throw new IllegalArgumentException(
                    "Attempt count must be positive.");
        }

        this.username = username.strip();
        this.attemptCount = attemptCount;
    }

    @Override
    public String getLevel() {
        return "SECURITY";
    }

    @Override
    protected String buildDetail() {
        return attemptCount + " failed logins for " + username;
    }

    @Override
    public String suggestFix() {
        return "lock account " + username;
    }
}

final class BackupAlert extends Alert {

    private final String backupName;
    private final int sizeInMegabytes;

    public BackupAlert(
            long id, String source, String backupName, int sizeInMegabytes) {
        super(id, source);

        if (backupName == null || backupName.isBlank()) {
            throw new IllegalArgumentException("Backup name is required.");
        }

        if (sizeInMegabytes <= 0) {
            throw new IllegalArgumentException(
                    "Backup size must be positive.");
        }

        this.backupName = backupName.strip();
        this.sizeInMegabytes = sizeInMegabytes;
    }

    @Override
    public String getLevel() {
        return "INFO";
    }

    @Override
    protected String buildDetail() {
        return backupName + " backup finished (" + sizeInMegabytes + " MB)";
    }
}

interface AlertChannel {

    boolean deliver(String text);
}

final class ConsoleAlertChannel implements AlertChannel {

    @Override
    public boolean deliver(String text) {
        System.out.println(text);
        return true;
    }
}

final class OfflineAlertChannel implements AlertChannel {

    @Override
    public boolean deliver(String text) {
        return false;
    }
}

final class AlertDispatcher {

    private final AlertChannel channel;
    private final Alert[] alerts;

    public AlertDispatcher(AlertChannel channel, Alert[] alerts) {
        if (channel == null) {
            throw new IllegalArgumentException("Alert channel is required.");
        }

        if (alerts == null) {
            throw new IllegalArgumentException("Alerts are required.");
        }

        for (Alert alert : alerts) {
            if (alert == null) {
                throw new IllegalArgumentException(
                        "Alerts cannot contain null.");
            }
        }

        this.channel = channel;
        this.alerts = Arrays.copyOf(alerts, alerts.length);
    }

    public boolean send(Alert alert) {
        if (alert == null || alert.isSent()) {
            return false;
        }

        String text = alert.render();

        if (alert instanceof Fixable fixable) {
            text = text + " (fix: " + fixable.suggestFix() + ")";
        }

        if (!channel.deliver(text)) {
            return false;
        }

        return alert.markSent();
    }

    public int sendAll() {
        int sentCount = 0;

        for (Alert alert : alerts) {
            if (send(alert)) {
                sentCount++;
            }
        }

        return sentCount;
    }
}
