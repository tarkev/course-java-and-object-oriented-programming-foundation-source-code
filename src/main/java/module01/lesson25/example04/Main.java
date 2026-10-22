package module01.lesson25.example04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine().strip();
        while (name.isBlank()) {
            System.out.println("Name is required.");
            System.out.print("Enter your name: ");
            name = scanner.nextLine().strip();
        }
        System.out.println("Hello, " + name + "!");

        scanner.close();
    }
}
