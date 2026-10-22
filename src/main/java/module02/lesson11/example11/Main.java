package module02.lesson11.example11;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {3, 1, 2};
        int[] sorted = Arrays.copyOf(numbers, numbers.length);

        Arrays.sort(sorted);

        System.out.println("Original: " + Arrays.toString(numbers));
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
