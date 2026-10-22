package module06.lesson10.example03;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = merge(new int[] {2, 7, 9}, new int[] {1, 5, 8, 10, 12});
        int[] b = merge(new int[] {1, 1, 4}, new int[] {1, 3});
        int[] c = merge(new int[] {}, new int[] {3, 4});

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }

    static int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                result[k] = first[i];
                i++;
            } else {
                result[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            result[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            result[k] = second[j];
            j++;
            k++;
        }

        return result;
    }
}
