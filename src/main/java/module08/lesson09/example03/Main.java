package module08.lesson09.example03;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String[] inputs = {" advanced ", "Beginner", "expert", "", null};

        for (String input : inputs) {
            System.out.println("[" + input + "] → " + Difficulty.fromText(input));
        }
    }
}

enum Difficulty {

    BEGINNER, INTERMEDIATE, ADVANCED;

    static Optional<Difficulty> fromText(String value) {
        if (value == null || value.isBlank()) {
            return Optional.empty();
        }

        String normalizedValue = value.strip().toUpperCase();

        for (Difficulty difficulty : values()) {
            if (difficulty.name().equals(normalizedValue)) {
                return Optional.of(difficulty);
            }
        }

        return Optional.empty();
    }
}
