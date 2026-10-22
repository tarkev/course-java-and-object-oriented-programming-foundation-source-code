// Generated from modules/01-programming-and-java-fundamentals/18-while-and-do-while-loops.md by tools/extract_code.py. Edit the lesson, not this file.
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
