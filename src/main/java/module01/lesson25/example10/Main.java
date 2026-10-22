package module01.lesson25.example10;

import java.util.Scanner;

public class Main {

    static final int CALCULATE_OPTION = 1;
    static final int RULES_OPTION = 2;
    static final int EXIT_OPTION = 3;

    static final int BEGINNER_FEE = 3000;
    static final int INTERMEDIATE_FEE = 5000;
    static final int ADVANCED_FEE = 8000;

    static final int MINIMUM_COURSES = 1;
    static final int MAXIMUM_COURSES = 5;
    static final int DISCOUNT_MINIMUM_COURSES = 3;
    static final int DISCOUNT_PERCENT = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("=== Course Fee Calculator ===");
            System.out.println("1. Calculate fee");
            System.out.println("2. View fee rules");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine().strip());

            switch (option) {
                case CALCULATE_OPTION -> {
                    String name;
                    while (true) {
                        System.out.print("Learner name: ");
                        name = scanner.nextLine().strip();
                        if (!name.isBlank()) {
                            break;
                        }
                        System.out.println("Name is required.");
                    }

                    String level;
                    int feePerCourse;
                    while (true) {
                        System.out.print("Level (beginner/intermediate/advanced): ");
                        level = scanner.nextLine().strip().toLowerCase();
                        feePerCourse = switch (level) {
                            case "beginner" -> BEGINNER_FEE;
                            case "intermediate" -> INTERMEDIATE_FEE;
                            case "advanced" -> ADVANCED_FEE;
                            default -> 0;
                        };
                        if (feePerCourse > 0) {
                            break;
                        }
                        System.out.println("Unknown level.");
                    }

                    int courseCount;
                    while (true) {
                        System.out.print("Number of courses ("
                                + MINIMUM_COURSES + "-" + MAXIMUM_COURSES + "): ");
                        courseCount = Integer.parseInt(scanner.nextLine().strip());
                        if (courseCount >= MINIMUM_COURSES && courseCount <= MAXIMUM_COURSES) {
                            break;
                        }
                        System.out.println("Number of courses must be between "
                                + MINIMUM_COURSES + " and " + MAXIMUM_COURSES + ".");
                    }

                    int subtotal = feePerCourse * courseCount;
                    int discount = 0;
                    if (courseCount >= DISCOUNT_MINIMUM_COURSES) {
                        discount = subtotal * DISCOUNT_PERCENT / 100;
                    }
                    int total = subtotal - discount;

                    System.out.println();
                    System.out.println("--- Fee Summary ---");
                    System.out.println("Learner: " + name);
                    System.out.println("Level: " + level);
                    System.out.println("Courses: " + courseCount + " x "
                            + feePerCourse + " taka");
                    System.out.println("Subtotal: " + subtotal + " taka");
                    System.out.println("Discount: " + discount + " taka");
                    System.out.println("Total: " + total + " taka");
                    System.out.println();
                }
                case RULES_OPTION -> {
                    System.out.println("Beginner: " + BEGINNER_FEE + " taka per course");
                    System.out.println("Intermediate: " + INTERMEDIATE_FEE
                            + " taka per course");
                    System.out.println("Advanced: " + ADVANCED_FEE + " taka per course");
                    System.out.println(DISCOUNT_MINIMUM_COURSES + " or more courses: "
                            + DISCOUNT_PERCENT + "% discount");
                    System.out.println();
                }
                case EXIT_OPTION -> System.out.println("Goodbye.");
                default -> System.out.println("Invalid option. Choose 1, 2 or 3.\n");
            }
        } while (option != EXIT_OPTION);

        scanner.close();
    }
}
