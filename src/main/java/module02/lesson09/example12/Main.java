package module02.lesson09.example12;

public class Main {

    public static void main(String[] args) {
        greet();
        greet("Sumu");
    }

    static void greet() {
        greet("Guest");
    }

    static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
