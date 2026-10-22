package module01.lesson21.example03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Course duration in weeks: ");
        int weeks = scanner.nextInt();
        System.out.print("Course name: ");
        String courseName = scanner.nextLine();
        System.out.println("Course: " + courseName + " (" + weeks + " weeks)");
        scanner.close();
    }
}
