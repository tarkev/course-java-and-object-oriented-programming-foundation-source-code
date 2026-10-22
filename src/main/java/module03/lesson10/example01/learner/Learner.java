package module03.lesson10.example01.learner;

public class Learner {

    private final long id;
    private final String name;

    public Learner(long id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Learner ID must be positive.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Learner name is required.");
        }

        this.id = id;
        this.name = name.strip();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
