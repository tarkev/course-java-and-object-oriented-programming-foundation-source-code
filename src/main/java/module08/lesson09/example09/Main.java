package module08.lesson09.example09;

public class Main {

    public static void main(String[] args) {
        String[] inputs = {"49900", " ", "49.90", "-100"};

        for (String input : inputs) {
            try {
                System.out.println("Price: " + parsePrice(input));
            } catch (IllegalArgumentException exception) {
                System.out.println("Rejected: " + exception.getMessage());
                System.out.println("  Cause: " + exception.getCause());
            }
        }
    }

    static long parsePrice(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Price is required.");
        }

        long price;

        try {
            price = Long.parseLong(value.strip());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "Price must be a whole number of paisa: " + value, exception);
        }

        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative: " + price);
        }

        return price;
    }
}
