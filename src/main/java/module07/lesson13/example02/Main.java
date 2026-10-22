package module07.lesson13.example02;

import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Optional<String> first = Stream.of("Nur", "Sakib", "Subu")
                .filter(name -> {
                    System.out.println("Checking " + name);
                    return name.startsWith("S");
                })
                .findFirst();

        System.out.println(first.orElse("none"));
    }
}
