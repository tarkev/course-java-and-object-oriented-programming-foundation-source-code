package module02.lesson11.example09;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] first = {1, 2, 3};
        int[] second = {1, 2, 3};

        System.out.println(first == second);
        System.out.println(Arrays.equals(first, second));
    }
}
