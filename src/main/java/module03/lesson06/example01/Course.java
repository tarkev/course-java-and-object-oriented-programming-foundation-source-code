package module03.lesson06.example01;

public class Course {

    private static int totalCoursesCreated;

    private String title;
    private int totalLessons;

    public Course(String title, int totalLessons) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (totalLessons <= 0) {
            throw new IllegalArgumentException(
                    "Total lessons must be greater than zero.");
        }

        this.title = title.strip();
        this.totalLessons = totalLessons;
        totalCoursesCreated++;
    }

    public static int getTotalCoursesCreated() {
        return totalCoursesCreated;
    }
}
