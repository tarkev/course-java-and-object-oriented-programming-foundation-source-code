package module02.lesson10.example02;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
