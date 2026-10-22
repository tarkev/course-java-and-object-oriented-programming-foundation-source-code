package module01.lesson25.example10;

import java.util.Scanner;

public class Main {

    static final int MINIMUM_DAYS = 1;
    static final int MAXIMUM_DAYS = 14;
    static final int MINIMUM_MINUTES = 0;
    static final int MAXIMUM_MINUTES = 600;
    static final int GOAL_MINUTES = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Study Streak Tracker ===");

        String name;
        do {
            System.out.print("Learner name: ");
            name = scanner.nextLine().strip();
            if (name.isBlank()) {
                System.out.println("Name is required.");
            }
        } while (name.isBlank());

        int dayCount;
        while (true) {
            System.out.print("Number of days (" + MINIMUM_DAYS + "-" + MAXIMUM_DAYS + "): ");
            dayCount = Integer.parseInt(scanner.nextLine().strip());
            if (dayCount >= MINIMUM_DAYS && dayCount <= MAXIMUM_DAYS) {
                break;
            }
            System.out.println("Days must be between "
                    + MINIMUM_DAYS + " and " + MAXIMUM_DAYS + ".");
        }

        int totalMinutes = 0;
        int goalDays = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day = 1; day <= dayCount; day++) {
            int minutes;
            while (true) {
                System.out.print("Day " + day + " minutes ("
                        + MINIMUM_MINUTES + "-" + MAXIMUM_MINUTES + "): ");
                minutes = Integer.parseInt(scanner.nextLine().strip());
                if (minutes >= MINIMUM_MINUTES && minutes <= MAXIMUM_MINUTES) {
                    break;
                }
                System.out.println("Minutes must be between "
                        + MINIMUM_MINUTES + " and " + MAXIMUM_MINUTES + ".");
            }

            totalMinutes += minutes;
            if (minutes >= GOAL_MINUTES) {
                goalDays++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        double averageMinutes = (double) totalMinutes / dayCount;

        String message = switch (longestStreak) {
            case 0 -> "No 30-minute day yet. Start with one tomorrow.";
            case 1, 2 -> "A good start. Aim for three days in a row.";
            case 3, 4, 5, 6 -> "Strong habit. Keep the chain going.";
            default -> "A week or more in a row. Excellent work.";
        };

        System.out.println();
        System.out.println("--- Study Report for " + name + " ---");
        System.out.println("Total: " + totalMinutes + " minutes");
        System.out.println("Average: " + averageMinutes + " minutes per day");
        System.out.println("Days with " + GOAL_MINUTES + "+ minutes: "
                + goalDays + " of " + dayCount);
        System.out.println("Longest streak: " + longestStreak + " days");
        System.out.println(message);

        scanner.close();
    }
}
