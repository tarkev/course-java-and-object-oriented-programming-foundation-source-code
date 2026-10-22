package module01.lesson23.example25;

public class Main {

    public static void main(String[] args) {
        String roleInput = "  learner ";

        String role = roleInput.strip().toUpperCase();
        String dashboard = switch (role) {
            case "ADMIN" -> "Admin dashboard";
            case "INSTRUCTOR" -> "Instructor dashboard";
            case "LEARNER" -> "Learner dashboard";
            default -> "Unknown role";
        };
        System.out.println(dashboard);
    }
}
