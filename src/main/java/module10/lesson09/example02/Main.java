package module10.lesson09.example02;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Money price = new Money(499_000, " bdt ");
        System.out.println(price);
        System.out.println(price.equals(new Money(499_000, "BDT")));

        try {
            new Money(-1, "BDT");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

record Money(long amountInPaisa, String currency) {

    Money {
        if (amountInPaisa < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }

        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency is required.");
        }

        currency = currency.strip().toUpperCase(Locale.ROOT);
    }
}
