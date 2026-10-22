package module02.lesson10.example25;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        System.out.println(sum(numbers));
    }

    static int sum(int[] numbers) {
        return sum(numbers, 0);
    }

    static int sum(int[] numbers, int index) {
        if (index == numbers.length) {
            return 0;
        }
        return numbers[index] + sum(numbers, index + 1);
    }
}
