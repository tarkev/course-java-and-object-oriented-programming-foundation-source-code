package module01.lesson24.example15;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mark;
        do {
            System.out.print("Enter a mark (0-100): ");
            mark = Integer.parseInt(scanner.nextLine().strip());
            if (mark < 0 || mark > 100) {
                System.out.println("Mark must be between 0 and 100.");
            }
        } while (mark < 0 || mark > 100);
        System.out.println("Valid mark: " + mark);

        scanner.close();
    }
}
