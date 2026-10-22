// Generated from modules/03-object-oriented-programming-foundations/10-packages-and-organizing-java-code.md by tools/extract_code.py. Edit the lesson, not this file.
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
