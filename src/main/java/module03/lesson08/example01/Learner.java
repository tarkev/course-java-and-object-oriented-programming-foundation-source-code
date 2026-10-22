package module03.lesson08.example01;

public class Learner {

    private final long id;
    private final String name;
    private final String email;

    public Learner(long id, String name, String email) {
        if (id <= 0) {
            throw new IllegalArgumentException("Learner ID must be positive.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Learner name is required.");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Learner email is required.");
        }

        this.id = id;
        this.name = name.strip();
        this.email = email.strip();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
