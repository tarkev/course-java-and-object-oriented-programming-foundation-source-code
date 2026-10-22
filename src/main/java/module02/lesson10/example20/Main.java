package module02.lesson10.example20;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] first = {{1, 2}, {3, 4}};
        int[][] second = {{1, 2}, {3, 4}};

        System.out.println(Arrays.equals(first, second));
        System.out.println(Arrays.deepEquals(first, second));
    }
}
