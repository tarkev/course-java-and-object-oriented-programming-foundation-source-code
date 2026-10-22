package module07.lesson14.example05;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

    static final LocalTime CLASS_TIME = LocalTime.of(18, 30);
    static final ZoneId CLASS_ZONE = ZoneId.of("Europe/Tallinn");

    public static void main(String[] args) {
        System.out.println(classStart(LocalDate.of(2026, 1, 12)));
        System.out.println(classStart(LocalDate.of(2026, 7, 13)));
    }

    static Instant classStart(LocalDate date) {
        return ZonedDateTime.of(date, CLASS_TIME, CLASS_ZONE).toInstant();
    }
}
