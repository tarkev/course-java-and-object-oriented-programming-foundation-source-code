package module10.lesson10.example05;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<EmailAddress> emails = new HashSet<>();
        emails.add(new EmailAddress("Nur@Tarkev.com"));
        emails.add(new EmailAddress(" nur@tarkev.com"));
        System.out.println(emails);
    }
}

final class EmailAddress {

    private final String value;

    EmailAddress(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email address is required.");
        }

        this.value = value.strip().toLowerCase(Locale.ROOT);
    }

    String value() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof EmailAddress email && value.equals(email.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
