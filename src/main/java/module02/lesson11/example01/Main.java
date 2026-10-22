package module02.lesson11.example01;

public class Main {
    public static void main(String[] args) {
        System.out.println("Even positions: " + sumEvenPositions(new int[] {5, 1, 7, 2, 3}));
        System.out.println("Above average: " + countAboveAverage(new int[] {10, 20, 30, 40}));
        System.out.println("Even values: " + countEven(new int[] {12, 7, 30, -4, 9}));
        System.out.println("Range: " + range(new int[] {12, 7, 40, 15}));
        System.out.println("Second largest: " + secondLargest(new int[] {12, 7, 40, 15}));
        System.out.println("Sorted {3, 5, 5, 9}: " + isSortedAscending(new int[] {3, 5, 5, 9}));
        System.out.println("Sorted {3, 8, 5}: " + isSortedAscending(new int[] {3, 8, 5}));
        System.out.println("Sorted {}: " + isSortedAscending(new int[0]));
        System.out.println("Last index of 4: " + lastIndexOf(new int[] {4, 7, 4, 9}, 4));
        System.out.println("Last index of 5: " + lastIndexOf(new int[] {4, 7, 4, 9}, 5));
    }

    static int sumEvenPositions(int[] numbers) {
        int total = 0;
        for (int index = 0; index < numbers.length; index += 2) {
            total += numbers[index];
        }
        return total;
    }

    static int countAboveAverage(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        double average = (double) total / numbers.length;

        int count = 0;
        for (int number : numbers) {
            if (number > average) {
                count++;
            }
        }
        return count;
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

    static int range(int[] numbers) {
        int smallest = numbers[0];
        int largest = numbers[0];
        for (int number : numbers) {
            if (number < smallest) {
                smallest = number;
            }
            if (number > largest) {
                largest = number;
            }
        }
        return largest - smallest;
    }

    static int secondLargest(int[] numbers) {
        int largest = numbers[0];
        int second = numbers[1];
        if (second > largest) {
            largest = numbers[1];
            second = numbers[0];
        }
        for (int index = 2; index < numbers.length; index++) {
            if (numbers[index] > largest) {
                second = largest;
                largest = numbers[index];
            } else if (numbers[index] > second) {
                second = numbers[index];
            }
        }
        return second;
    }

    static boolean isSortedAscending(int[] numbers) {
        for (int index = 1; index < numbers.length; index++) {
            if (numbers[index] < numbers[index - 1]) {
                return false;
            }
        }
        return true;
    }

    static int lastIndexOf(int[] numbers, int target) {
        for (int index = numbers.length - 1; index >= 0; index--) {
            if (numbers[index] == target) {
                return index;
            }
        }
        return -1;
    }
}
