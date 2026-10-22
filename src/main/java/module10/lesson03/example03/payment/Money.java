package module10.lesson03.example03.payment;

import java.util.Locale;
import java.util.Objects;

public final class Money {

    private final long amount;
    private final String currency;

    public Money(long amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }

        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency is required.");
        }

        this.amount = amount;
        this.currency = currency.strip().toUpperCase(Locale.ROOT);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Money money)) {
            return false;
        }

        return amount == money.amount && currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
