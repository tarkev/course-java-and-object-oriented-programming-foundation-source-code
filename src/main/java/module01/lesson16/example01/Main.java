package module01.lesson16.example01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Create course");
        System.out.println("2. View courses");
        System.out.println("3. Update course");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int option = Integer.parseInt(scanner.nextLine().strip());

        String action = switch (option) {
            case 1 -> "Create course";
            case 2 -> "View courses";
            case 3 -> "Update course";
            case 4 -> "Exit";
            default -> "Invalid option";
        };

        System.out.println("Selected: " + action);

        scanner.close();
    }
}
