package module02.lesson01.example10;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start");
        greet();
        printLine();
        System.out.println("End");
    }

    static void greet() {
        printLine();
        System.out.println("Hello");
    }

    static void printLine() {
        System.out.println("---");
    }
}
