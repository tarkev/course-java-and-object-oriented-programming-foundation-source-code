package module11.lesson06.example01.learner;

public final class LearnerNotFoundException extends RuntimeException {

    public LearnerNotFoundException(LearnerId learnerId) {
        super("Learner not found: " + learnerId + ".");
    }
}
