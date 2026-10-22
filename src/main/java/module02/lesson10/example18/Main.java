package module02.lesson10.example18;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40};
        int index = Arrays.binarySearch(numbers, 30);

        System.out.println("Index: " + index);
        System.out.println("Exists: " + (index >= 0));
    }
}
