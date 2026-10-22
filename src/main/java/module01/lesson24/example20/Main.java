package module01.lesson24.example20;

public class Main {

    public static void main(String[] args) {
        for (int number = 1; number <= 10; number++) {
            System.out.println(number);
            if (number == 5) {
                break;
            }
        }
    }
}
