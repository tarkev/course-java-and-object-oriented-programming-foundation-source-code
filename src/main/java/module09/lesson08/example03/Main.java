package module09.lesson08.example03;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path base = Path.of("/data/courses");
        String[] inputs = {"java/lesson.md", "../../secret.txt"};

        for (String input : inputs) {
            try {
                System.out.println("Allowed: " + resolveInside(base, input));
            } catch (IllegalArgumentException exception) {
                System.out.println("Rejected " + input + ": "
                        + exception.getMessage());
            }
        }
    }

    static Path resolveInside(Path base, String input) {
        Path normalizedBase = base.toAbsolutePath().normalize();
        Path target = normalizedBase.resolve(input).normalize();

        if (!target.startsWith(normalizedBase)) {
            throw new IllegalArgumentException(
                    "Path escapes the allowed directory.");
        }

        return target;
    }
}
