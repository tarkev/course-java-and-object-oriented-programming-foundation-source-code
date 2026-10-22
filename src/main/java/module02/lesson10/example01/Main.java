package module02.lesson10.example01;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {12, 7, 30, -4, 9};

        System.out.println("Sum: " + sum(numbers));
        System.out.println("Average: " + average(numbers));
        System.out.println("Even values: " + countEven(numbers));
        System.out.println("Max: " + max(numbers));
        System.out.println("Min: " + min(numbers));
        System.out.println("Contains 30: " + contains(numbers, 30));
        System.out.println("Contains 5: " + contains(numbers, 5));
        System.out.println("Index of 30: " + indexOf(numbers, 30));
        System.out.println("Index of 5: " + indexOf(numbers, 5));
    }

    static int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    static double average(int[] numbers) {
        return (double) sum(numbers) / numbers.length;
    }

    static int countEven(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    static int max(int[] numbers) {
        int maximum = numbers[0];
        for (int number : numbers) {
            if (number > maximum) {
                maximum = number;
            }
        }
        return maximum;
    }

    static int min(int[] numbers) {
        int minimum = numbers[0];
        for (int number : numbers) {
            if (number < minimum) {
                minimum = number;
            }
        }
        return minimum;
    }

    static boolean contains(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }

    static int indexOf(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
