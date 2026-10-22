package module07.lesson07.example03;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {
        ZoneId tallinn = ZoneId.of("Europe/Tallinn");
        ZonedDateTime start =
                ZonedDateTime.of(2026, 3, 28, 9, 0, 0, 0, tallinn);

        System.out.println(start);
        System.out.println(start.plusDays(1));
        System.out.println(start.plus(Duration.ofHours(24)));
    }
}
