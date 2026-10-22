package module02.lesson09.example03;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arrivalOrder = {42, 17, 30};
        int[] sorted = arrivalOrder;
        Arrays.sort(sorted);

        System.out.println("Sorted:   " + Arrays.toString(sorted));
        System.out.println("Original: " + Arrays.toString(arrivalOrder));
    }
}
