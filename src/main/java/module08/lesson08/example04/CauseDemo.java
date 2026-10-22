package module08.lesson08.example04;

public class CauseDemo {

    static int parseSeats(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            throw new IllegalStateException("Bad seat count in import.", exception);
        }
    }

    public static void main(String[] args) {
        try {
            parseSeats("ten");
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
            System.out.println(exception.getCause().getClass().getSimpleName());
            System.out.println(exception.getCause().getMessage());
        }
    }
}
