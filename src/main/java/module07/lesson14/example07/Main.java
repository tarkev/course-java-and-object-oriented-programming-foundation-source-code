package module07.lesson14.example07;

public class Main {

    public static void main(String[] args) {
        PriceRule rule = PriceRule.between(0, 100_000).or(price -> price > 1_000_000);

        System.out.println(rule.test(50_000));
        System.out.println(rule.test(500_000));
        System.out.println(rule.test(1_500_000));
    }
}

@FunctionalInterface
interface PriceRule {

    boolean test(long priceInPaisa);

    default PriceRule or(PriceRule other) {
        return price -> test(price) || other.test(price);
    }

    static PriceRule between(long minimum, long maximum) {
        return price -> price >= minimum && price <= maximum;
    }
}
