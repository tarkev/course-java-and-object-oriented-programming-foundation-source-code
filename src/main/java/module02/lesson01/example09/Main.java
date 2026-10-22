package module02.lesson01.example09;

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
