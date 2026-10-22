package module01.lesson24.example13;

public class Main {

    public static void main(String[] args) {
        int number = 1;
        int sum = 0;
        while (number <= 100) {
            sum += number;
            number++;
        }
        System.out.println(sum);
    }
}
