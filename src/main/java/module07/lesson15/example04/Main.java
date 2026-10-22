package module07.lesson15.example04;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {
        Enrollment enrollment =
                new Enrollment("Sumu", Instant.parse("2026-03-01T10:00:00Z"));

        System.out.println(enrollment.canCancel(Instant.parse("2026-03-04T10:00:00Z")));
        System.out.println(enrollment.canCancel(Instant.parse("2026-03-04T10:00:01Z")));

        System.out.println("Sumu: " + enrollment.enrolledAt().atZone(ZoneId.of("Asia/Dhaka")));
        System.out.println("Jalisa: "
                + enrollment.enrolledAt().atZone(ZoneId.of("Europe/Tallinn")));
    }
}

class Enrollment {

    private static final Duration CANCELLATION_WINDOW = Duration.ofHours(72);

    private final String learnerName;
    private final Instant enrolledAt;

    Enrollment(String learnerName, Instant enrolledAt) {
        this.learnerName = learnerName;
        this.enrolledAt = enrolledAt;
    }

    boolean canCancel(Instant now) {
        return !now.isAfter(enrolledAt.plus(CANCELLATION_WINDOW));
    }

    Instant enrolledAt() {
        return enrolledAt;
    }
}
