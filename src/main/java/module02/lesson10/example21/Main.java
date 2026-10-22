package module02.lesson10.example21;

public class Main {
    public static void main(String[] args) {
        countDown(5);
    }

    static void countDown(int number) {
        if (number == 0) {
            return;
        }
        System.out.println(number);
        countDown(number - 1);
    }
}
