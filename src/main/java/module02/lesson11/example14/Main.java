package module02.lesson11.example14;

public class Main {
    public static void main(String[] args) {
        System.out.println(countDigits(4096));
        System.out.println(countDigits(7));
        System.out.println(countDigits(0));
    }

    static int countDigits(int number) {
        if (number < 10) {
            return 1;
        }
        return 1 + countDigits(number / 10);
    }
}
