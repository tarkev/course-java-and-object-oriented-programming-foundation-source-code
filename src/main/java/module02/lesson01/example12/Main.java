// Generated from modules/02-methods-arrays-and-program-structure/01-introduction-to-methods.md by tools/extract_code.py. Edit the lesson, not this file.
package module02.lesson01.example12;

public class Main {

    public static void main(String[] args) {
        showHeader();
        showCourses();
        showFooter();
    }

    static void showHeader() {
        System.out.println("======================");

        System.out.println("Tarkev");

        System.out.println("======================");
    }

    static void showCourses() {
        System.out.println("Available Courses");

        System.out.println("1. Java and OOP Foundation");

        System.out.println("2. Backend Development");
    }

    static void showFooter() {
        System.out.println("======================");

        System.out.println("Learn. Live. Grow.");
    }
}
