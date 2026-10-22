package module10.lesson03.example02.payment;

public class SymmetryDemo {

    static class Price {

        private final long priceInPaisa;

        Price(long priceInPaisa) {
            this.priceInPaisa = priceInPaisa;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Price price)) {
                return false;
            }

            return priceInPaisa == price.priceInPaisa;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(priceInPaisa);
        }
    }

    static class DiscountedPrice extends Price {

        private final int percentOff;

        DiscountedPrice(long priceInPaisa, int percentOff) {
            super(priceInPaisa);
            this.percentOff = percentOff;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof DiscountedPrice discounted)) {
                return false;
            }

            return super.equals(discounted) && percentOff == discounted.percentOff;
        }

        @Override
        public int hashCode() {
            return 31 * super.hashCode() + percentOff;
        }
    }

    public static void main(String[] args) {
        Price price = new Price(50_000);
        DiscountedPrice discounted = new DiscountedPrice(50_000, 10);

        System.out.println(price.equals(discounted));
        System.out.println(discounted.equals(price));
    }
}
