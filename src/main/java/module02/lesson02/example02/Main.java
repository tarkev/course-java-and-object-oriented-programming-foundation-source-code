package module02.lesson02.example02;

public class Main {

    public static void main(String[] args) {
        long total = calculateTotal(499_000L, 2);
        boolean largeOrder = isLargeOrder(total);
        String message = createOrderMessage(total, largeOrder);

        System.out.println(message);
    }

    static long calculateTotal(long priceInPaisa, int quantity) {
        return priceInPaisa * quantity;
    }

    static boolean isLargeOrder(long total) {
        return total > 500_000L;
    }

    static String createOrderMessage(long total, boolean largeOrder) {
        if (largeOrder) {
            return "Large order: " + total;
        }
        return "Order total: " + total;
    }
}
