package module02.lesson11.example07;

public class Main {
    public static void main(String[] args) {
        int[][] values = {{1, 5}, {5, 2, 8}, {7, 5}};
        System.out.println(everyRowContains(values, 5));
        System.out.println(everyRowContains(values, 2));
    }

    static boolean everyRowContains(int[][] values, int target) {
        for (int[] row : values) {
            if (!rowContains(row, target)) {
                return false;
            }
        }
        return true;
    }

    static boolean rowContains(int[] row, int target) {
        for (int value : row) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}
