package module03.lesson13.example05;

public class Main {

    public static void main(String[] args) {
        Course course = new Course("Java and OOP Foundation", 0, 20);

        System.out.println("Published: " + course.isPublished());
        System.out.println("First publish: " + course.publish());
        System.out.println("Second publish: " + course.publish());
        System.out.println("Published: " + course.isPublished());
    }
}

class Course {

    private String title;
    private long priceInPaisa;
    private int totalLessons;
    private boolean published;

    public Course(String title, long priceInPaisa, int totalLessons) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (priceInPaisa < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        if (totalLessons <= 0) {
            throw new IllegalArgumentException(
                    "Total lessons must be greater than zero.");
        }

        this.title = title.strip();
        this.priceInPaisa = priceInPaisa;
        this.totalLessons = totalLessons;
        this.published = false;
    }

    public boolean publish() {
        if (published) {
            return false;
        }

        published = true;
        return true;
    }

    public String getTitle() {
        return title;
    }

    public long getPriceInPaisa() {
        return priceInPaisa;
    }

    public int getTotalLessons() {
        return totalLessons;
    }

    public boolean isPublished() {
        return published;
    }
}
