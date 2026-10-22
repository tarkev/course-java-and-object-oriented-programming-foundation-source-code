package module07.lesson13.example04;

import java.time.LocalDate;

public class Main {

    record Booking(String learner, LocalDate date) {
    }

    public static void main(String[] args) {
        Booking first = new Booking("Sumu", LocalDate.of(2026, 1, 31));
        Booking second = new Booking("Sumu", LocalDate.of(2026, 1, 31));

        System.out.println(first == second);
        System.out.println(first.equals(second));
        System.out.println(first.date().plusMonths(1));
        System.out.println(first);
    }
}
