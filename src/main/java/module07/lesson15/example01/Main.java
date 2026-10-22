package module07.lesson15.example01;

import java.util.Locale;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        EmailAddress first = new EmailAddress(" Nur@Tarkev.com");
        EmailAddress second = new EmailAddress("nur@tarkev.com");

        System.out.println(first);
        System.out.println(first.equals(second));
    }

    record LearnerId(long value) {

        LearnerId {
            if (value < 1) {
                throw new IllegalArgumentException("Learner id must be at least 1.");
            }
        }
    }

    record EmailAddress(String value) {

        EmailAddress {
            value = Objects.requireNonNull(value, "Email is required.")
                    .strip()
                    .toLowerCase(Locale.ROOT);

            if (value.isBlank() || !value.contains("@")) {
                throw new IllegalArgumentException("Invalid email: " + value);
            }
        }
    }
}
