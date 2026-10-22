package module06.lesson11.example05;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        print(new int[] {2, 4, 1, 3, 5});
        print(new int[] {5, 4, 3, 2, 1});
        print(new int[] {1, 2, 3, 4});
        print(new int[] {3, 1, 3, 2});
    }

    static void print(int[] numbers) {
        String before = Arrays.toString(numbers);
        System.out.println(before + " -> " + countInversions(numbers) + " inversions");
    }

    static long countInversions(int[] numbers) {
        int[] buffer = new int[numbers.length];
        return countInversions(numbers, buffer, 0, numbers.length - 1);
    }

    static long countInversions(int[] numbers, int[] buffer, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int middle = left + (right - left) / 2;
        long count = countInversions(numbers, buffer, left, middle);
        count += countInversions(numbers, buffer, middle + 1, right);
        count += merge(numbers, buffer, left, middle, right);
        return count;
    }

    static long merge(int[] numbers, int[] buffer, int left, int middle, int right) {
        int leftIndex = left;
        int rightIndex = middle + 1;
        int bufferIndex = left;
        long inversions = 0;

        while (leftIndex <= middle && rightIndex <= right) {
            if (numbers[leftIndex] <= numbers[rightIndex]) {
                buffer[bufferIndex] = numbers[leftIndex];
                leftIndex++;
            } else {
                buffer[bufferIndex] = numbers[rightIndex];
                rightIndex++;
                inversions += middle - leftIndex + 1;
            }

            bufferIndex++;
        }

        while (leftIndex <= middle) {
            buffer[bufferIndex] = numbers[leftIndex];
            leftIndex++;
            bufferIndex++;
        }

        while (rightIndex <= right) {
            buffer[bufferIndex] = numbers[rightIndex];
            rightIndex++;
            bufferIndex++;
        }

        for (int index = left; index <= right; index++) {
            numbers[index] = buffer[index];
        }

        return inversions;
    }
}
