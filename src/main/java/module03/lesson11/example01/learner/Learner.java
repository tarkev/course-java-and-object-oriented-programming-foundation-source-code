// Generated from modules/03-object-oriented-programming-foundations/11-project-build-a-course-enrollment-system.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson11.example01.learner;

import java.util.Objects;

public final class Learner {

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

        if (email == null || email.isBlank() || !email.contains("@")
                || email.contains(" ")) {
            throw new IllegalArgumentException(
                    "A valid learner email is required.");
        }

        this.id = id;

        this.name = name.strip();

        this.email = email.strip().toLowerCase();
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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Learner learner = (Learner) other;

        return id == learner.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Learner{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
