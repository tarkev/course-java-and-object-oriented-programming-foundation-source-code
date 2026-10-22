package module02.lesson11.example03;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{10, 20, 30}, {40, 50, 60}};

        System.out.println(matrix[1][1]);
        matrix[1][2] = 99;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
