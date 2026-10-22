package module06.lesson10.example02;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40};

        boolean found = Arrays.binarySearch(numbers, 30) >= 0;
        boolean missing = Arrays.binarySearch(numbers, 35) >= 0;

        System.out.println("30 found: " + found);
        System.out.println("35 found: " + missing);
    }
}
