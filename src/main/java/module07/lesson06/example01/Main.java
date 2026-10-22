package module07.lesson06.example01;

import java.util.Optional;

public class Main {

    static String loadFallbackTitle() {
        System.out.println("Loading fallback title...");
        return "Unknown";
    }

    public static void main(String[] args) {
        Optional<String> title = Optional.of("Java Foundation");

        System.out.println(title.orElse(loadFallbackTitle()));
        System.out.println(title.orElseGet(() -> loadFallbackTitle()));
    }
}
