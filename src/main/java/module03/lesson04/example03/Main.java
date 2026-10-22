package module03.lesson04.example03;

public class Main {

    static void show(int value) {
        System.out.println("int: " + value);
    }

    static void show(long value) {
        System.out.println("long: " + value);
    }

    public static void main(String[] args) {
        show(20);
        show(20L);
    }
}
