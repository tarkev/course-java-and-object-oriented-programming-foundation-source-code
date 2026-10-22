// Generated from modules/01-programming-and-java-fundamentals/15-conditional-statements.md by tools/extract_code.py. Edit the lesson, not this file.
package module01.lesson15.example02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your mark: ");

        int mark = Integer.parseInt(scanner.nextLine().strip());

        if (mark < 0 || mark > 100) {
            System.out.println("Invalid mark");
        } else if (mark >= 80) {
            System.out.println("Grade: A");
        } else if (mark >= 70) {
            System.out.println("Grade: B");
        } else if (mark >= 60) {
            System.out.println("Grade: C");
        } else if (mark >= 50) {
            System.out.println("Grade: D");
        } else if (mark >= 40) {
            System.out.println("Grade: E");
        } else {
            System.out.println("Grade: F");
        }

        scanner.close();
    }
}
