package module02.lesson10.example04;

public class Main {

    public static void main(String[] args) {
        showHeader();
        showCourses();
        showFooter();
    }

    static void showHeader() {
        System.out.println("Tarkev");
        System.out.println("----------------");
    }

    static void showCourses() {
        System.out.println("1. Java");
        System.out.println("2. Backend");
        System.out.println("3. System Design");
    }

    static void showFooter() {
        System.out.println("----------------");
        System.out.println("Learn. Live. Grow.");
    }
}
