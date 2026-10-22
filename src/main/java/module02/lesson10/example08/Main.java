package module02.lesson10.example08;

public class Main {
    public static void main(String[] args) {
        int[][] values = {{1, 2}, {3, 4, 5}, {6}};

        int count = 0;
        for (int[] row : values) {
            count += row.length;
        }

        System.out.println(count);
    }
}
