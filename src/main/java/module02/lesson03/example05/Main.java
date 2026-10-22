package module02.lesson03.example05;

public class Main {

    public static void main(String[] args) {
        show(5);
        show(5L);
        show(2.5);
    }

    static void show(long value) {
        System.out.println("long");
    }

    static void show(double value) {
        System.out.println("double");
    }
}
