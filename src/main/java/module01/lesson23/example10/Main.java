package module01.lesson23.example10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a language: ");
        String language = scanner.nextLine().strip().toLowerCase();
        System.out.println(language);

        scanner.close();
    }
}
