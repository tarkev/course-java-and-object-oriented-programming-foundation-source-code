package module10.lesson03.example03.payment;

import java.util.HashSet;
import java.util.Set;

public class MoneyDemo {

    public static void main(String[] args) {
        Set<Money> prices = new HashSet<>();
        prices.add(new Money(50_000, "BDT"));
        prices.add(new Money(50_000, " bdt"));
        prices.add(new Money(50_000, "USD"));

        System.out.println(prices.size());
        System.out.println(prices.contains(new Money(50_000, "bdt")));
    }
}
