package module03.lesson06.example02;

public class PriceCalculator {

    public static long applyDiscount(
            long priceInPaisa, int discountPercentage) {
        if (priceInPaisa < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException(
                    "Discount must be between 0 and 100.");
        }

        long discountAmount = priceInPaisa * discountPercentage / 100;
        return priceInPaisa - discountAmount;
    }
}
