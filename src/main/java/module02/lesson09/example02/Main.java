package module02.lesson09.example02;

public class Main {

    public static void main(String[] args) {
        int[] minutes = {12, 8, 15};
        System.out.println(total(minutes));
    }

    static int total(int[] values) {
        int sum = 0;

        for (int i = 0; i <= values.length; i++) {
            sum += values[i];
        }

        return sum;
    }
}
