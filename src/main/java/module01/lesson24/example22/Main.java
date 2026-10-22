package module01.lesson24.example22;

public class Main {

    public static void main(String[] args) {
        for (int number = 1; number <= 20; number++) {
            if (number % 2 != 0) {
                continue;
            }
            System.out.println(number);
        }
    }
}
