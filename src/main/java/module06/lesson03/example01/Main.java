package module06.lesson03.example01;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] original = {8, 3, 5, 1, 9, 2};
        int[] mergeValues = Arrays.copyOf(original, original.length);
        int[] quickValues = Arrays.copyOf(original, original.length);

        mergeSort(mergeValues);
        quickSort(quickValues);

        System.out.println(Arrays.toString(mergeValues));
        System.out.println(Arrays.toString(quickValues));
    }

    static void mergeSort(int[] numbers) {
        if (numbers.length < 2) {
            return;
        }

        int[] buffer = new int[numbers.length];
        mergeSort(numbers, buffer, 0, numbers.length - 1);
    }

    static void mergeSort(
            int[] numbers, int[] buffer, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;
        mergeSort(numbers, buffer, left, middle);
        mergeSort(numbers, buffer, middle + 1, right);
        merge(numbers, buffer, left, middle, right);
    }

    static void merge(
            int[] numbers, int[] buffer, int left, int middle, int right) {
        int leftIndex = left;
        int rightIndex = middle + 1;
        int bufferIndex = left;

        while (leftIndex <= middle && rightIndex <= right) {
            if (numbers[leftIndex] <= numbers[rightIndex]) {
                buffer[bufferIndex] = numbers[leftIndex];
                leftIndex++;
            } else {
                buffer[bufferIndex] = numbers[rightIndex];
                rightIndex++;
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
    }

    static void quickSort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    static void quickSort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(numbers, left, right);
        quickSort(numbers, left, pivotIndex - 1);
        quickSort(numbers, pivotIndex + 1, right);
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

    static void swap(int[] numbers, int firstIndex, int secondIndex) {
        int temporary = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temporary;
    }
}
