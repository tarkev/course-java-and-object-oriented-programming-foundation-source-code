package module02.lesson04.example07;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int count = 3;

        update(numbers, count);

        System.out.println(numbers[0]);
        System.out.println(count);
    }

    static void update(int[] values, int count) {
        values[0] = 99;
        count = 99;
    }
}
