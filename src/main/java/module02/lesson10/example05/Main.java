package module02.lesson10.example05;

public class Main {

    public static void main(String[] args) {
        greet("Sakib");
        greet("Nur");
        greet("Subu");
    }

    static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
