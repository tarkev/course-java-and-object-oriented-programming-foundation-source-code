package module02.lesson10.example14;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        int[] larger = Arrays.copyOf(numbers, 5);
        System.out.println(Arrays.toString(larger));
    }
}
