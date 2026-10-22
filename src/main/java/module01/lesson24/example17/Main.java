package module01.lesson24.example17;

import java.util.Scanner;

public class Main {

    static final int SENTINEL = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int total = 0;
        System.out.print("Enter a number (-1 to stop): ");
        int number = Integer.parseInt(scanner.nextLine().strip());
        while (number != SENTINEL) {
            total += number;
            System.out.print("Enter a number (-1 to stop): ");
            number = Integer.parseInt(scanner.nextLine().strip());
        }
        System.out.println("Total: " + total);

        scanner.close();
    }
}
