package module07.lesson07.example04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

        LocalDate date = LocalDate.of(2026, 8, 8);
        String formatted = date.format(formatter);
        LocalDate parsed = LocalDate.parse("08/08/2026", formatter);

        System.out.println(formatted);
        System.out.println(parsed);
    }
}
