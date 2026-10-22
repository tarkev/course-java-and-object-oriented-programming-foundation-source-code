package module08.lesson08.example03;

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

    static Difficulty fromText(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        String normalizedValue = value.strip().toUpperCase();

        for (Difficulty difficulty : values()) {
            if (difficulty.name().equals(normalizedValue)) {
                return difficulty;
            }
        }

        return null;
    }
}
