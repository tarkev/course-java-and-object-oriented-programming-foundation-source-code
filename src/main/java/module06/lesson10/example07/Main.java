package module06.lesson10.example07;

public class Main {

    public static void main(String[] args) {
        int[] sorted = {10, 20, 40, 50, 70};

        for (int target : new int[] {40, 30, 5, 90, 70}) {
            System.out.println(binarySearch(sorted, target));
        }
    }

    static int binarySearch(int[] sorted, int target) {
        return binarySearch(sorted, target, 0, sorted.length - 1);
    }

    static int binarySearch(int[] sorted, int target, int left, int right) {
        if (left > right) {
            return -left - 1;
        }

        int middle = left + (right - left) / 2;
        int value = sorted[middle];

        if (value == target) {
            return middle;
        }

        if (value < target) {
            return binarySearch(sorted, target, middle + 1, right);
        }

        return binarySearch(sorted, target, left, middle - 1);
    }
}
