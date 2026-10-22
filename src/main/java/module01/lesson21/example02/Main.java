package module01.lesson21.example02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Confirm enrollment (yes/no): ");
        String answer = scanner.nextLine().strip();
        if (answer == "yes") {
            System.out.println("Enrollment confirmed.");
        } else {
            System.out.println("Enrollment cancelled.");
        }
        scanner.close();
    }
}
