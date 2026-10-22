package module01.lesson12.example01;

public class Main {

    public static void main(String[] args) {
        int mathematicsMark = 80;
        int englishMark = 90;
        int scienceMark = 85;

        int totalMarks = mathematicsMark + englishMark + scienceMark;
        double averageMark = totalMarks / 3.0;
        boolean passed =
                mathematicsMark >= 40 && englishMark >= 40 && scienceMark >= 40;

        System.out.println("Total: " + totalMarks);
        System.out.println("Average: " + averageMark);
        System.out.println("Passed: " + passed);
    }
}
