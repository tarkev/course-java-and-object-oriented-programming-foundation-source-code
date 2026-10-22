package module10.lesson10.example03;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        EmailAddress email = new EmailAddress("  Subu@Tarkev.COM ");
        System.out.println(email);
        System.out.println(email.equals(new EmailAddress("subu@tarkev.com")));

        try {
            new EmailAddress("   ");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

record EmailAddress(String value) {

    EmailAddress {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email address is required.");
        }

        value = value.strip().toLowerCase(Locale.ROOT);
    }
}
