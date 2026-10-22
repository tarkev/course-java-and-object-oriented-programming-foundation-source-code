package module01.lesson23.example07;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine().strip();
        System.out.println("Welcome, " + fullName);

        scanner.close();
    }
}
