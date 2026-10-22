package module03.lesson14.example01.course;

import java.util.Objects;

public final class CourseFee {

    private final int amount;
    private final String currency;

    public CourseFee(int amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Fee amount cannot be negative.");
        }

        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency is required.");
        }

        this.amount = amount;
        this.currency = currency.strip().toUpperCase();
    }

    public CourseFee plus(CourseFee other) {
        if (other == null) {
            throw new IllegalArgumentException("Fee is required.");
        }

        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match.");
        }

        return new CourseFee(amount + other.amount, currency);
    }

    public CourseFee discountedBy(int percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Percent must be 0 to 100.");
        }

        return new CourseFee(amount - amount * percent / 100, currency);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        CourseFee fee = (CourseFee) other;

        return amount == fee.amount && currency.equals(fee.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return currency + " " + amount;
    }
}
