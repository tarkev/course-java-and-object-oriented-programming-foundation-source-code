package module01.lesson24.example21;

public class Main {

    public static void main(String[] args) {
        for (int number = 1; number <= 10; number++) {
            if (number == 5) {
                continue;
            }
            System.out.println(number);
        }
    }
}
