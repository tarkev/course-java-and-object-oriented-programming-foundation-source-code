package module06.lesson02.example01;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] original = {40, 10, 30, 20};
        int[] bubble = Arrays.copyOf(original, original.length);
        int[] selection = Arrays.copyOf(original, original.length);
        int[] insertion = Arrays.copyOf(original, original.length);

        bubbleSort(bubble);
        selectionSort(selection);
        insertionSort(insertion);

        System.out.println(Arrays.toString(bubble));
        System.out.println(Arrays.toString(selection));
        System.out.println(Arrays.toString(insertion));
    }

    static void bubbleSort(int[] numbers) {
        for (int pass = 0; pass < numbers.length - 1; pass++) {
            boolean swapped = false;

            for (int i = 0; i < numbers.length - 1 - pass; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    swap(numbers, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                return;
            }
        }
    }

    static void selectionSort(int[] numbers) {
        for (int start = 0; start < numbers.length - 1; start++) {
            int minIndex = start;

            for (int i = start + 1; i < numbers.length; i++) {
                if (numbers[i] < numbers[minIndex]) {
                    minIndex = i;
                }
            }

            if (minIndex != start) {
                swap(numbers, start, minIndex);
            }
        }
    }

    static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int position = i - 1;

            while (position >= 0 && numbers[position] > current) {
                numbers[position + 1] = numbers[position];
                position--;
            }

            numbers[position + 1] = current;
        }
    }

    static void swap(int[] numbers, int firstIndex, int secondIndex) {
        int temporary = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temporary;
    }
}
