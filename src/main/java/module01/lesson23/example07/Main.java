package module01.lesson23.example07;

public class Main {

    public static void main(String[] args) {
        String studentName = "Nur";
        int mathematicsMark = 85;
        int englishMark = 78;
        int scienceMark = 92;
        int total = mathematicsMark + englishMark + scienceMark;
        double average = total / 3.0;
        char grade = 'A';
        boolean passed = true;

        System.out.println("Student: " + studentName);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Passed: " + passed);
    }
}
