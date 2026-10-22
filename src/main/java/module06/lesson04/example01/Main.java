package module06.lesson04.example01;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int index = Arrays.binarySearch(numbers, 30);
        System.out.println(index);
    }
}
