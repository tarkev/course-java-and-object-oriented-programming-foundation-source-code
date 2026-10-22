package module03.lesson13.example03;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        EmailAddress first = new EmailAddress("  Nur@Example.COM ");
        EmailAddress second = new EmailAddress("nur@example.com");

        System.out.println(first.getValue());
        System.out.println(first == second);
        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());
    }
}

final class EmailAddress {

    private final String value;

    EmailAddress(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email address is required.");
        }

        String normalizedValue = value.strip().toLowerCase();

        if (!normalizedValue.contains("@")) {
            throw new IllegalArgumentException(
                    "Email address must contain @.");
        }

        this.value = normalizedValue;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        EmailAddress emailAddress = (EmailAddress) other;
        return value.equals(emailAddress.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
