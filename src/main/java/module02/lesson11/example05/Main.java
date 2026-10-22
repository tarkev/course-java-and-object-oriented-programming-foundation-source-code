package module02.lesson11.example05;

public class Main {
    public static void main(String[] args) {
        int[][] values = {{3, 8, 1}, {9, 2, 5}, {4, 4, 4}};
        System.out.println(largestRowIndex(values));
    }

    static int largestRowIndex(int[][] values) {
        int best = 0;
        for (int row = 1; row < values.length; row++) {
            if (total(values[row]) > total(values[best])) {
                best = row;
            }
        }
        return best;
    }

    static int total(int[] row) {
        int total = 0;
        for (int value : row) {
            total += value;
        }
        return total;
    }
}
