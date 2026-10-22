package module01.lesson25.example07;

import java.util.Scanner;

public class Main {

    static final int SENTINEL = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int total = 0;
        while (true) {
            System.out.print("Enter a number (-1 to stop): ");
            int number = Integer.parseInt(scanner.nextLine().strip());
            if (number == SENTINEL) {
                break;
            }
            total += number;
        }
        System.out.println("Total: " + total);

        scanner.close();
    }
}
