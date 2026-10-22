package module02.lesson02.example07;

public class Main {

    public static void main(String[] args) {
        int value = add(multiply(2, 3), subtract(10, add(1, 4)));
        System.out.println(value);
        System.out.println(multiply(value, 2));
    }

    static int add(int first, int second) {
        return first + second;
    }

    static int subtract(int first, int second) {
        return first - second;
    }

    static int multiply(int first, int second) {
        return first * second;
    }
}
