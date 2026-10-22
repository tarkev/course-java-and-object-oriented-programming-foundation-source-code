package module02.lesson10.example26;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        System.out.println(contains(numbers, 20));
        System.out.println(contains(numbers, 50));
    }

    static boolean contains(int[] numbers, int target) {
        return contains(numbers, target, 0);
    }

    static boolean contains(int[] numbers, int target, int index) {
        if (index == numbers.length) {
            return false;
        }
        if (numbers[index] == target) {
            return true;
        }
        return contains(numbers, target, index + 1);
    }
}
