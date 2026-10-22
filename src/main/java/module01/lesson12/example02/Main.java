// Generated from modules/01-programming-and-java-fundamentals/12-operators-and-expressions.md by tools/extract_code.py. Edit the lesson, not this file.
package module01.lesson12.example02;

public class Main {

    public static void main(String[] args) {
        int learnerAge = 20;

        boolean emailVerified = true;
        boolean accountBlocked = false;
        boolean enrollmentOpen = true;

        boolean canEnroll =
                learnerAge >= 18
                && emailVerified && !accountBlocked && enrollmentOpen;

        System.out.println("Can enroll: " + canEnroll);
    }
}
