package module02.lesson10.example24;

public class Main {
    public static void main(String[] args) {
        System.out.println(sumTo(5));
    }

    static int sumTo(int number) {
        if (number == 0) {
            return 0;
        }
        return number + sumTo(number - 1);
    }
}
