package module01.lesson24.example09;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine().strip();
        System.out.print("Enter your age: ");
        int age = Integer.parseInt(scanner.nextLine().strip());
        System.out.print("Enter the course price: ");
        double coursePrice = Double.parseDouble(scanner.nextLine().strip());

        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course price: " + coursePrice);

        scanner.close();
    }
}
