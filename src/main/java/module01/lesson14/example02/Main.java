// Generated from modules/01-programming-and-java-fundamentals/14-reading-user-input.md by tools/extract_code.py. Edit the lesson, not this file.
package module01.lesson14.example02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");

        String name = scanner.nextLine();

        System.out.println("Hello, " + name);

        scanner.close();
    }
}
