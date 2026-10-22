package module08.lesson08.example05;

enum Level {
    BEGINNER(1), INTERMEDIATE(2), ADVANCED(3);

    private final int rank;

    Level(int rank) {
        this.rank = rank;
    }

    boolean canTake(Level course) {
        return course.rank <= rank + 1;
    }
}

public class LevelDemo {

    public static void main(String[] args) {
        Level learner = Level.valueOf("BEGINNER");

        for (Level course : Level.values()) {
            System.out.println(course + " " + learner.canTake(course));
        }

        try {
            Level.valueOf("Expert");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
