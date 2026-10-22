package module03.lesson06.example02;

public class Course {

    public static final int MAX_TITLE_LENGTH = 150;

    private static int totalCoursesCreated;

    private String title;
    private int totalLessons;
    private long priceInPaisa;

    private boolean published;

    public Course(String title, int totalLessons, long priceInPaisa) {
        validateTitle(title);

        if (totalLessons <= 0) {
            throw new IllegalArgumentException(
                    "Total lessons must be greater than zero.");
        }

        if (priceInPaisa < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        this.title = title.strip();
        this.totalLessons = totalLessons;
        this.priceInPaisa = priceInPaisa;
        this.published = false;
        totalCoursesCreated++;
    }

    private static void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (title.strip().length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException(
                    "Course title cannot exceed " + MAX_TITLE_LENGTH + " characters.");
        }
    }

    public static int getTotalCoursesCreated() {
        return totalCoursesCreated;
    }

    public boolean publish() {
        if (published) {
            return false;
        }

        published = true;
        return true;
    }

    public long calculateDiscountedPrice(int discountPercentage) {
        return PriceCalculator.applyDiscount(
                priceInPaisa, discountPercentage);
    }

    public String getTitle() {
        return title;
    }

    public int getTotalLessons() {
        return totalLessons;
    }

    public long getPriceInPaisa() {
        return priceInPaisa;
    }

    public boolean isPublished() {
        return published;
    }
}
