package module03.lesson04.example01;

public class Course {

    String title;
    int totalLessons;
    long priceInPaisa;
    boolean published;

    Course(String title, int totalLessons) {
        this(title, totalLessons, 0);
    }

    Course(String title, int totalLessons, long priceInPaisa) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

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
    }

    void publish() {
        published = true;
    }

    void changeTitle(String title) {
        if (title == null || title.isBlank()) {
            return;
        }

        this.title = title.strip();
    }

    void changePrice(long priceInPaisa) {
        if (priceInPaisa < 0) {
            return;
        }

        this.priceInPaisa = priceInPaisa;
    }
}
