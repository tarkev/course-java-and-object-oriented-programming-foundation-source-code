package module01.lesson24.example06;

public class Main {

    public static void main(String[] args) {
        int number = 7;
        for (int multiplier = 1; multiplier <= 10; multiplier++) {
            int result = number * multiplier;
            System.out.println(number + " × " + multiplier + " = " + result);
        }
    }
}
