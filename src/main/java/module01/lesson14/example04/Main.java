package module01.lesson14.example04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine().strip();
        System.out.print("Enter mathematics mark: ");
        int mathematicsMark = Integer.parseInt(scanner.nextLine().strip());
        System.out.print("Enter English mark: ");
        int englishMark = Integer.parseInt(scanner.nextLine().strip());
        System.out.print("Enter science mark: ");
        int scienceMark = Integer.parseInt(scanner.nextLine().strip());

        int totalMarks = mathematicsMark + englishMark + scienceMark;
        double averageMark = totalMarks / 3.0;

        System.out.println();
        System.out.println("Student: " + studentName);
        System.out.println("Total: " + totalMarks);
        System.out.println("Average: " + averageMark);

        scanner.close();
    }
}
