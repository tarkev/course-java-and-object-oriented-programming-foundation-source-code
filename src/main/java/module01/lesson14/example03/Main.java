// Generated from modules/01-programming-and-java-fundamentals/14-reading-user-input.md by tools/extract_code.py. Edit the lesson, not this file.
package module01.lesson14.example03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");

        String name = scanner.nextLine().strip();

        System.out.print("Enter your age: ");

        int age = Integer.parseInt(scanner.nextLine().strip());

        System.out.println();
        System.out.println("Name: " + name);

        System.out.println("Age: " + age);

        scanner.close();
    }
}
