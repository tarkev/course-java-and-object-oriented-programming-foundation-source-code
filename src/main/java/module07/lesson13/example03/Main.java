package module07.lesson13.example03;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String level = Optional.of("  java ")
                .map(String::strip)
                .filter(text -> text.length() > 4)
                .orElse("too short");

        System.out.println(level);
    }
}
