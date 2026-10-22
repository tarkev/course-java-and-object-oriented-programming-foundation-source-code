package module07.lesson07.example02;

import java.time.Instant;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {
        Instant createdAt = Instant.parse("2026-08-08T17:00:00Z");

        System.out.println(createdAt);
        System.out.println(createdAt.atZone(ZoneId.of("Europe/Tallinn")));
        System.out.println(createdAt.atZone(ZoneId.of("Asia/Dhaka")));
    }
}
