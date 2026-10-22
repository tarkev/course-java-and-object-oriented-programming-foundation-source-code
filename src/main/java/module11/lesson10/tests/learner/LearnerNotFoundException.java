package module11.lesson10.tests.learner;

public final class LearnerNotFoundException extends RuntimeException {

    public LearnerNotFoundException(LearnerId learnerId) {
        super("Learner not found: " + learnerId + ".");
    }
}
