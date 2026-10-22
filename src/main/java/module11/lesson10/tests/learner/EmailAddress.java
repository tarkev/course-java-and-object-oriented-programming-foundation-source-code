package module11.lesson10.tests.learner;

import java.util.Locale;

public record EmailAddress(String value) {

    public EmailAddress {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email address is required.");
        }

        value = value.strip().toLowerCase(Locale.ROOT);

        if (value.contains(" ") || !value.matches("^[^@]+@[^@]+\\.[^@]+$")) {
            throw new IllegalArgumentException("Email address is invalid.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
