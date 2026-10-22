package module02.lesson11.example16;

public class Main {
    public static void main(String[] args) {
        System.out.println(power(2, 10));
        System.out.println(power(3, 4));
        System.out.println(power(5, 0));
    }

    static long power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
}
