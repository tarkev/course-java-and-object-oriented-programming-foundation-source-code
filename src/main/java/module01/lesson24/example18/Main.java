package module01.lesson24.example18;

import java.util.Scanner;

public class Main {

    static final int VIEW_COURSES = 1;
    static final int CREATE_COURSE = 2;
    static final int EXIT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("1. View courses");
            System.out.println("2. Create course");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine().strip());

            switch (option) {
                case VIEW_COURSES -> System.out.println("Showing courses\n");
                case CREATE_COURSE -> System.out.println("Creating a course\n");
                case EXIT -> System.out.println("Goodbye");
                default -> System.out.println("Invalid option\n");
            }
        } while (option != EXIT);

        scanner.close();
    }
}
