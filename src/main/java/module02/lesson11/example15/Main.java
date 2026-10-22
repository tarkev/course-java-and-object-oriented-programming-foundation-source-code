package module02.lesson11.example15;

public class Main {
    public static void main(String[] args) {
        printUpTo(5);
    }

    static void printUpTo(int number) {
        if (number == 0) {
            return;
        }
        printUpTo(number - 1);
        System.out.println(number);
    }
}
