package module07.lesson07.example05;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Instant publishedAt = Instant.parse("2026-08-08T17:00:00Z");
        Instant expiresAt = publishedAt.plus(Duration.ofHours(48));

        ZoneId tallinn = ZoneId.of("Europe/Tallinn");
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMM uuuu HH:mm", Locale.ENGLISH);

        System.out.println(expiresAt);
        System.out.println(publishedAt.atZone(tallinn).format(formatter));
        System.out.println(expiresAt.atZone(tallinn).format(formatter));
    }
}
