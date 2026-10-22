package module03.lesson12.example03;

public class Main {

    public static void main(String[] args) {
        Course course = new Course("  Java and OOP Foundation  ", 20, 0);

        System.out.println("[" + course.title + "]");
        System.out.println(course.totalLessons + " lessons");
        System.out.println(course.priceInPaisa + " paisa");
    }
}

class Course {

    String title;
    int totalLessons;
    long priceInPaisa;

    Course(String initialTitle, int initialTotalLessons,
            long initialPriceInPaisa) {
        if (initialTitle == null || initialTitle.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (initialTotalLessons <= 0) {
            throw new IllegalArgumentException(
                    "Total lessons must be greater than zero.");
        }

        if (initialPriceInPaisa < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        title = initialTitle.strip();
        totalLessons = initialTotalLessons;
        priceInPaisa = initialPriceInPaisa;
    }
}
