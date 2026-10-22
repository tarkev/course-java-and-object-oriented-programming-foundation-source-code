package module08.lesson09.example05;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println(new LearnerEmail("  Nur@Example.COM ").getValue());

        String[] inputs = {" ", "nur.example.com", "nur@", "nur@tarkev@com"};

        for (String input : inputs) {
            try {
                new LearnerEmail(input);
            } catch (IllegalArgumentException exception) {
                System.out.println("[" + input + "] " + exception.getMessage());
            }
        }
    }
}

final class LearnerEmail {

    private final String value;

    public LearnerEmail(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }

        String normalized = value.strip().toLowerCase(Locale.ROOT);
        int at = normalized.indexOf('@');

        if (at <= 0 || at != normalized.lastIndexOf('@')
                || at == normalized.length() - 1) {
            throw new IllegalArgumentException("Email format is invalid.");
        }

        this.value = normalized;
    }

    public String getValue() {
        return value;
    }
}
