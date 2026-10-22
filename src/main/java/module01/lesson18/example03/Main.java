package module01.lesson18.example03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mark;

        do {
            System.out.print("Enter a mark between 0 and 100: ");
            mark = Integer.parseInt(scanner.nextLine().strip());
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid mark");
            }
        } while (mark < 0 || mark > 100);

        System.out.println("Valid mark: " + mark);

        scanner.close();
    }
}
