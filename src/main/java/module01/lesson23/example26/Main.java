package module01.lesson23.example26;

public class Main {

    public static void main(String[] args) {
        int option = 1;

        String result = switch (option) {
            case 1 -> {
                System.out.println("Creating course...");
                yield "Created";
            }
            case 2 -> "Updated";
            default -> "Unknown option";
        };
        System.out.println(result);
    }
}
