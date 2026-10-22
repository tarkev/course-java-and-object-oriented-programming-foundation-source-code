package module02.lesson11.example04;

public class Main {
    public static void main(String[] args) {
        int[][] values = {{1, 2, 3}, {10, 20, 30}};
        int[] totals = columnTotals(values);
        for (int total : totals) {
            System.out.print(total + " ");
        }
        System.out.println();
    }

    static int[] columnTotals(int[][] values) {
        int[] totals = new int[values[0].length];
        for (int row = 0; row < values.length; row++) {
            for (int column = 0; column < values[row].length; column++) {
                totals[column] += values[row][column];
            }
        }
        return totals;
    }
}
