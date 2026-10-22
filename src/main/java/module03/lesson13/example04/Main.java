package module03.lesson13.example04;

public class Main {

    public static void main(String[] args) {
        Course free = new Course("Java and OOP Foundation", 20);
        Course paid = new Course("Backend Development", 30, 499_000);

        System.out.println(free.title + ": " + free.priceInPaisa);
        System.out.println(paid.title + ": " + paid.priceInPaisa);
    }
}

class Course {

    String title;
    int totalLessons;
    long priceInPaisa;

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
}
