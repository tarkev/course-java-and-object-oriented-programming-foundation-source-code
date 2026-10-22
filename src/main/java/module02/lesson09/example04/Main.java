package module02.lesson09.example04;

public class Main {

    public static void main(String[] args) {
        describe(5 / 2);
        describe(5 / 2.0);
    }

    static void describe(int value) {
        System.out.println("int " + value);
    }

    static void describe(double value) {
        System.out.println("double " + value);
    }
}
