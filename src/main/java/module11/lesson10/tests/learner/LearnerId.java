package module11.lesson10.tests.learner;

public record LearnerId(long value) {

    public LearnerId {
        if (value <= 0) {
            throw new IllegalArgumentException("Learner id must be positive.");
        }
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
