// Generated from modules/02-methods-arrays-and-program-structure/01-introduction-to-methods.md by tools/extract_code.py. Edit the lesson, not this file.
package module02.lesson01.example08;

public class Main {

    public static void main(String[] args) {
        showWelcomeMessage();
        showCourses();
        showEnrollmentConfirmation();
    }

    static void showWelcomeMessage() {
        System.out.println("Welcome to Tarkev!");
    }

    static void showCourses() {
        System.out.println("Available courses:");

        System.out.println("1. Java and OOP Foundation");

        System.out.println("2. Backend Development");
    }

    static void showEnrollmentConfirmation() {
        System.out.println("Enrollment completed.");
    }
}
