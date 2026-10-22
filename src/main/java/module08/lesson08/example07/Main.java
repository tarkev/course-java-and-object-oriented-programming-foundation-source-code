package module08.lesson08.example07;

public class Main {

    public static void main(String[] args) {
        validatePrice(49_900L);
        System.out.println("49900 paisa is a valid price.");
        validatePrice(-100L);
        System.out.println("This line is never printed.");
    }

    static void validatePrice(long priceInPaisa) {
        if (priceInPaisa < 0) {
            throw new IllegalArgumentException(
                    "Price cannot be negative, but was: " + priceInPaisa);
        }
    }
}
