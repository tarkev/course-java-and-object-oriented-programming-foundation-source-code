package module01.lesson24.example24;

public class Main {

    public static void main(String[] args) {
        char grade = 'B';

        String description = switch (grade) {
            case 'A' -> "Excellent";
            case 'B' -> "Very good";
            case 'C' -> "Good";
            case 'D' -> "Needs improvement";
            case 'F' -> "Failed";
            default -> "Unknown grade";
        };
        System.out.println(description);
    }
}
