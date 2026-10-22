package module07.lesson07.example01;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2026, 1, 31);
        LocalDate renewal = start.plusMonths(1);

        System.out.println(start);
        System.out.println(renewal);
        System.out.println(renewal.plusMonths(1));
        System.out.println(LocalDate.of(2024, 1, 31).plusMonths(1));
    }
}
