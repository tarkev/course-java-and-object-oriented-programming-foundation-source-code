package module07.lesson14.example07;

public class Main {

    public static void main(String[] args) {
        String template = """
                Hello %s,

                Welcome to %s! Your first lesson is ready.

                The Tarkev team
                """;

        System.out.print(template.formatted("Subu", "Java Foundation"));
    }
}
