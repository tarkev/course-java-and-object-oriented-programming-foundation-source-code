package module06.lesson10.example01;

public class Main {

    public static void main(String[] args) {
        int[] sorted = {10, 20, 30, 40, 50, 60, 70};

        System.out.println(binarySearch(sorted, 60));
        System.out.println(binarySearch(sorted, 35));
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

        return -1;
    }
}
