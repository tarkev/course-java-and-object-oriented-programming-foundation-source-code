package module11.lesson06.example01.learner;

public record Learner(LearnerId id, String name, EmailAddress email) {

    public Learner {
        if (id == null) {
            throw new IllegalArgumentException("Learner id is required.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Learner name is required.");
        }

        if (email == null) {
            throw new IllegalArgumentException("Learner email is required.");
        }

        name = name.strip();
    }
}
