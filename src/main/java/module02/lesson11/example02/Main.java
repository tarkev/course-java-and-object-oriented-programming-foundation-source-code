package module02.lesson11.example02;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        reverse(numbers);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    static void reverse(int[] numbers) {
        for (int left = 0; left < numbers.length / 2; left++) {
            int right = numbers.length - 1 - left;
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
        }
    }
}
