package module07.lesson04.example01;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> values = List.of(10, 20, 30, 40);

        boolean found = values.stream()
                .anyMatch(value -> {
                    System.out.println("Checking " + value);
                    return value > 25;
                });

        System.out.println("Found: " + found);
    }
}
