package module02.lesson01.example12;

public class Main {

    public static void main(String[] args) {
        System.out.println("1");
        first();
        System.out.println("4");
    }

    static void first() {
        System.out.println("2");
        second();
    }

    static void second() {
        System.out.println("3");
    }
}
