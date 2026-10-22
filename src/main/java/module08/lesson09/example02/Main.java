package module08.lesson09.example02;

public class Main {

    public static void main(String[] args) {
        Course course = new Course("Java and OOP Foundation", Difficulty.BEGINNER);
        System.out.println(course.getTitle() + " → " + course.getDifficulty());
    }
}

enum Difficulty {
    BEGINNER, INTERMEDIATE, ADVANCED
}

final class Course {

    private final String title;
    private final Difficulty difficulty;

    Course(String title, Difficulty difficulty) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (difficulty == null) {
            throw new IllegalArgumentException("Course difficulty is required.");
        }

        this.title = title.strip();
        this.difficulty = difficulty;
    }

    public String getTitle() {
        return title;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
