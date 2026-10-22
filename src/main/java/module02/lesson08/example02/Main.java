package module02.lesson08.example02;

public class Main {

    public static void main(String[] args) {
        System.out.println("Countdown:");
        countDown(5);
        System.out.println("Factorial: " + factorial(5));

        int[] numbers = {10, 20, 30};
        System.out.println("Array total: " + sum(numbers));
        System.out.println("Contains 20: " + contains(numbers, 20));
    }

    static void countDown(int number) {
        if (number == 0) {
            return;
        }

        System.out.println(number);
        countDown(number - 1);
    }

    static long factorial(int number) {
        if (number == 0) {
            return 1;
        }

        return number * factorial(number - 1);
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
