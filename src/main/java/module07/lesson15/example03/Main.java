package module07.lesson15.example03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM uuuu", Locale.ENGLISH);
        LocalDate startDate = LocalDate.of(2026, 3, 3);

        for (LocalDate reminder : reminderDates(startDate)) {
            System.out.println(reminder.format(formatter));
        }
    }

    static List<LocalDate> reminderDates(LocalDate startDate) {
        return List.of(startDate.minusDays(7), startDate.minusDays(1));
    }
}
