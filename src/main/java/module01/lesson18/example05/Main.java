package module01.lesson18.example05;

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

        String grade;

        if (mark >= 80) {
            grade = "A";
        } else if (mark >= 70) {
            grade = "B";
        } else if (mark >= 60) {
            grade = "C";
        } else if (mark >= 50) {
            grade = "D";
        } else if (mark >= 40) {
            grade = "E";
        } else {
            grade = "F";
        }

        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
