// Generated from modules/01-programming-and-java-fundamentals/13-type-conversion-and-casting.md by tools/extract_code.py. Edit the lesson, not this file.
package module01.lesson13.example02;

public class Main {

    public static void main(String[] args) {
        int totalMarks = 250;
        int subjectCount = 3;

        double average = (double) totalMarks / subjectCount;

        System.out.println("Average: " + average);
    }
}
