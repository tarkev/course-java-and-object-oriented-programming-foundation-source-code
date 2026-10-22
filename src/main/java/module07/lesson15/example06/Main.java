package module07.lesson15.example06;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        printMembership(LocalDate.of(2024, 11, 15), LocalDate.of(2026, 3, 20));
    }

    static void printMembership(LocalDate joinDate, LocalDate today) {
        Period period = Period.between(joinDate, today);
        long totalDays = ChronoUnit.DAYS.between(joinDate, today);

        System.out.println(period.getYears() + " years, " + period.getMonths()
                + " months, " + period.getDays() + " days");
        System.out.println(totalDays + " days in total");
    }
}
