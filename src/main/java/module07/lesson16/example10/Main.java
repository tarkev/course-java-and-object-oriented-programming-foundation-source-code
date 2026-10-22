package module07.lesson16.example10;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        System.out.println(priceText("JAVA").join());
        System.out.println(priceText("LEGACY").join());
    }

    static CompletableFuture<String> priceText(String courseCode) {
        return loadPrice(courseCode).handle((price, exception) -> {
            if (exception != null) {
                return "Price unavailable";
            }
            return "Price: " + price;
        });
    }

    static CompletableFuture<Long> loadPrice(String courseCode) {
        return CompletableFuture.supplyAsync(() -> {
            if (courseCode.equals("LEGACY")) {
                throw new IllegalStateException("No price for " + courseCode);
            }
            return 4999L;
        });
    }
}
