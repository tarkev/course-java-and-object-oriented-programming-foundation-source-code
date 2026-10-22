package module06.lesson10.example01;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {29, 5, 17, 5, 1};
        insertionSort(numbers);

        int[] empty = {};
        int[] single = {42};
        insertionSort(empty);
        insertionSort(single);
        System.out.println("Empty: " + Arrays.toString(empty));
        System.out.println("Single: " + Arrays.toString(single));
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
            System.out.println(Arrays.toString(numbers));
        }
    }
}
