package module02.lesson10.example06;

public class Main {
    public static void main(String[] args) {
        int[][] values = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int total = 0;
        for (int row = 0; row < values.length; row++) {
            total += values[row][1];
        }

        System.out.println(total);
    }
}
