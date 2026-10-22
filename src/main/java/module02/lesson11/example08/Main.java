package module02.lesson11.example08;

public class Main {
    public static void main(String[] args) {
        int[][] small = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] large = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(antiDiagonalSum(small));
        System.out.println(antiDiagonalSum(large));
    }

    static int antiDiagonalSum(int[][] matrix) {
        int total = 0;
        for (int index = 0; index < matrix.length; index++) {
            total += matrix[index][matrix.length - 1 - index];
        }
        return total;
    }
}
