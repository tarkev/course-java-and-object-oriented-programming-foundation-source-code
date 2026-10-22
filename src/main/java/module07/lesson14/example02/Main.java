package module07.lesson14.example02;

public class Main {

    public static void main(String[] args) {
        Course course = new Course("Git Basics", 40_000);

        System.out.println(finalPrice(course, price -> price));
        System.out.println(finalPrice(course, price -> price * 90 / 100));
        System.out.println(finalPrice(course, price -> Math.max(0, price - 50_000)));
    }

    static long finalPrice(Course course, PriceAdjustment adjustment) {
        return adjustment.adjust(course.priceInPaisa());
    }

    record Course(String title, long priceInPaisa) {
    }
}

@FunctionalInterface
interface PriceAdjustment {

    long adjust(long priceInPaisa);
}
