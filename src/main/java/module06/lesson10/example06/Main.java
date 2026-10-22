package module06.lesson10.example06;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] sorted = {10, 20, 40, 50, 70};
        int[] targets = {40, 30, 5, 90, 70};

        for (int target : targets) {
            System.out.println(binarySearch(sorted, target));
        }

        for (int target : targets) {
            if (binarySearch(sorted, target) != Arrays.binarySearch(sorted, target)) {
                System.out.println("Mismatch for " + target);
            }
        }
        System.out.println("Compared with Arrays.binarySearch()");
    }

    static int binarySearch(int[] sorted, int target) {
        int left = 0;
        int right = sorted.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int value = sorted[middle];

            if (value == target) {
                return middle;
            }

            if (value < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -left - 1;
    }
}
