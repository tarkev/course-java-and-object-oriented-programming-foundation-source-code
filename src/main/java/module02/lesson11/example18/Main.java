package module02.lesson11.example18;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {4, 7, 4, 9, 4};
        System.out.println(count(numbers, 4));
        System.out.println(count(numbers, 5));
    }

    static int count(int[] numbers, int target) {
        return count(numbers, target, 0);
    }

    static int count(int[] numbers, int target, int index) {
        if (index == numbers.length) {
            return 0;
        }
        int rest = count(numbers, target, index + 1);
        if (numbers[index] == target) {
            return 1 + rest;
        }
        return rest;
    }
}
