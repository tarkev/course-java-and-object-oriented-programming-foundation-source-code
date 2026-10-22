package module01.lesson10.example01;

public class Main {

    public static void main(String[] args) {
        String studentName = "Sakib";
        int mathematicsMark = 80;
        int englishMark = 90;
        int scienceMark = 85;

        int totalMarks = mathematicsMark + englishMark + scienceMark;
        double averageMark = totalMarks / 3.0;
        char grade = 'A';
        boolean isPassed = true;

        System.out.println("Student: " + studentName);
        System.out.println("Total: " + totalMarks);
        System.out.println("Average: " + averageMark);
        System.out.println("Grade: " + grade);
        System.out.println("Passed: " + isPassed);
    }
}
