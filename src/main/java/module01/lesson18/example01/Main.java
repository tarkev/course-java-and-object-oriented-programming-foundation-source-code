package module01.lesson18.example01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = Integer.parseInt(scanner.nextLine().strip());

        while (age < 0 || age > 150) {
            System.out.println("Invalid age");
            System.out.print("Enter an age between 0 and 150: ");
            age = Integer.parseInt(scanner.nextLine().strip());
        }

        System.out.println("Valid age: " + age);

        scanner.close();
    }
}
