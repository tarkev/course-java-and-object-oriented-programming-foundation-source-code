package module02.lesson10.example09;

public class Main {
    public static void main(String[] args) {
        int[][] values = {{1, 2}, {3, 4, 5}, {6}};

        System.out.println(contains(values, 4));
        System.out.println(contains(values, 9));
    }

    static boolean contains(int[][] values, int target) {
        for (int[] row : values) {
            for (int value : row) {
                if (value == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
