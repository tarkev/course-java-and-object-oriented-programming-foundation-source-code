package module03.lesson13.example07;

public class Main {

    public static void main(String[] args) {
        Course course = new Course("Java and OOP Foundation", 107);

        System.out.println(course.getTotalLessons() + " lessons");
        System.out.println("Limit: " + Course.MAX_LESSON_COUNT);
    }
}

class Course {

    public static final int MAX_LESSON_COUNT = 200;

    private String title;
    private int totalLessons;

    public Course(String title, int totalLessons) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (totalLessons <= 0 || totalLessons > MAX_LESSON_COUNT) {
            throw new IllegalArgumentException(
                    "Total lessons must be between 1 and "
                            + MAX_LESSON_COUNT + ".");
        }

        this.title = title.strip();
        this.totalLessons = totalLessons;
    }

    public int getTotalLessons() {
        return totalLessons;
    }
}
