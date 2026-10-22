package module07.lesson08.example01;

public class Main {

    public static void main(String[] args) {
        String learnerName = "Nur";

        String message = """
                Hello %s
                Welcome to the course.
                """.formatted(learnerName);

        System.out.print(message);
    }
}
