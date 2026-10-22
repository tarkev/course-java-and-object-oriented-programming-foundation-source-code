package module03.lesson13.example08;

public class Main {

    public static void main(String[] args) {
        System.out.println(PriceConverter.takaToPaisa(4_990));
        System.out.println(PriceConverter.takaToPaisa(0));
    }
}

class PriceConverter {

    public static long takaToPaisa(long taka) {
        if (taka < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }

        return taka * 100;
    }
}
