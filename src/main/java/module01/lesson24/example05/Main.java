package module01.lesson24.example05;

public class Main {

    public static void main(String[] args) {
        int sum = 0;
        for (int number = 1; number <= 100; number++) {
            sum += number;
        }
        System.out.println("Sum: " + sum);
    }
}
