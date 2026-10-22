package module01.lesson23.example11;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to continue? Enter yes or no: ");
        String answer = scanner.nextLine().strip();
        boolean shouldContinue = answer.equalsIgnoreCase("yes")
                || answer.equalsIgnoreCase("y");
        System.out.println("Continue: " + shouldContinue);

        scanner.close();
    }
}
