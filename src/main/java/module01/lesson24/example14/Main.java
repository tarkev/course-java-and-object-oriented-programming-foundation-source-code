package module01.lesson24.example14;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age (0-150): ");
        int age = Integer.parseInt(scanner.nextLine().strip());
        while (age < 0 || age > 150) {
            System.out.println("Age must be between 0 and 150.");
            System.out.print("Enter your age (0-150): ");
            age = Integer.parseInt(scanner.nextLine().strip());
        }
        System.out.println("Valid age: " + age);

        scanner.close();
    }
}
