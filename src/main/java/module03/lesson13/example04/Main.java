package module03.lesson13.example04;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] input = {80, 90, 70};
        Numbers numbers = new Numbers(input);

        input[0] = 0;
        numbers.getValues()[1] = 0;

        System.out.println(Arrays.toString(numbers.getValues()));
    }
}

final class Numbers {

    private final int[] values;

    Numbers(int[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public int[] getValues() {
        return Arrays.copyOf(values, values.length);
    }
}
