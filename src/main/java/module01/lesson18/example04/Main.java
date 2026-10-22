// Generated from modules/01-programming-and-java-fundamentals/18-while-and-do-while-loops.md by tools/extract_code.py. Edit the lesson, not this file.
package module01.lesson18.example04;

import java.util.Scanner;

public class Main {

    static final int VIEW_COURSES = 1;
    static final int CREATE_COURSE = 2;
    static final int EXIT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            System.out.println();
            System.out.println("1. View courses");

            System.out.println("2. Create course");

            System.out.println("3. Exit");

            System.out.print("Choose an option: ");

            option = Integer.parseInt(scanner.nextLine().strip());

            switch (option) {
                case VIEW_COURSES -> System.out.println("Loading courses");

                case CREATE_COURSE -> System.out.println("Opening course form");

                case EXIT -> System.out.println("Goodbye");

                default -> System.out.println("Invalid option");
            }
        } while (option != EXIT);

        scanner.close();
    }
}
