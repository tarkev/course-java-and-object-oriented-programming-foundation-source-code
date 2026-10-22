package module02.lesson01.example06;

public class Main {

    public static void main(String[] args) {
        startApplication();
    }

    static void startApplication() {
        showLogo();
        showMenu();
    }

    static void showLogo() {
        System.out.println("Tarkev");
    }

    static void showMenu() {
        System.out.println("1. Courses");
        System.out.println("2. Exit");
    }
}
