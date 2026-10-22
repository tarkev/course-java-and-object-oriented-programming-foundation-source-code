package module06.lesson11.example04;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        check(new int[] {6, 2, 8, 3, 5});
        check(new int[] {8, 3, 5, 1, 7});
        check(new int[] {4, 1, 4, 9, 4});
        check(new int[] {9, 8, 7});
        System.out.println(isPartitioned(new int[] {2, 6, 5, 3, 8}, 0, 4, 2));
    }

    static void check(int[] numbers) {
        int pivotIndex = partition(numbers, 0, numbers.length - 1);
        System.out.println("pivot index " + pivotIndex + ": " + Arrays.toString(numbers)
                + " " + isPartitioned(numbers, 0, numbers.length - 1, pivotIndex));
    }

    static int partition(int[] numbers, int left, int right) {
        int pivot = numbers[right];
        int smallerEnd = left - 1;

        for (int index = left; index < right; index++) {
            if (numbers[index] <= pivot) {
                smallerEnd++;
                swap(numbers, smallerEnd, index);
            }
        }

        int pivotIndex = smallerEnd + 1;
        swap(numbers, pivotIndex, right);
        return pivotIndex;
    }

    static boolean isPartitioned(int[] numbers, int left, int right, int pivotIndex) {
        int pivot = numbers[pivotIndex];

        for (int index = left; index < pivotIndex; index++) {
            if (numbers[index] > pivot) {
                return false;
            }
        }

        for (int index = pivotIndex + 1; index <= right; index++) {
            if (numbers[index] <= pivot) {
                return false;
            }
        }

        return true;
    }

    static void swap(int[] numbers, int first, int second) {
        int temporary = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temporary;
    }
}
