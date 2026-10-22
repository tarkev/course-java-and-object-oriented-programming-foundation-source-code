// Generated from modules/03-object-oriented-programming-foundations/01-introduction-to-object-oriented-design.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson01.example01;

public class Main {

    public static void main(String[] args) {
        String learnerName = "Nur";

        int completedLessons = 16;

        int totalLessons = 20;

        double progress = completedLessons * 100.0 / totalLessons;

        System.out.println(
                learnerName + " completed " + progress + "% of the course.");
    }
}
