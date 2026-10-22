package module02.lesson10.example23;

public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(6));
    }

    static long factorial(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
