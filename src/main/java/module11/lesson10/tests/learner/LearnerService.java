package module11.lesson10.tests.learner;

import java.util.List;

public final class LearnerService {

    private final LearnerRepository repository;

    public LearnerService(LearnerRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException("Learner repository is required.");
        }

        this.repository = repository;
    }

    public void registerLearner(
            LearnerId learnerId, String name, EmailAddress email) {
        if (learnerId == null || email == null) {
            throw new IllegalArgumentException(
                    "Learner id and email are required.");
        }

        if (repository.findById(learnerId).isPresent()) {
            throw new DuplicateLearnerException(
                    "Learner id already exists: " + learnerId + ".");
        }

        if (repository.findByEmail(email).isPresent()) {
            throw new DuplicateLearnerException(
                    "Learner email already exists: " + email + ".");
        }

        Learner learner = new Learner(learnerId, name, email);
        repository.save(learner);
    }

    public Learner findLearner(LearnerId learnerId) {
        if (learnerId == null) {
            throw new IllegalArgumentException("Learner id is required.");
        }

        return repository.findById(learnerId)
                .orElseThrow(() -> new LearnerNotFoundException(learnerId));
    }

    public List<Learner> findAllLearners() {
        return repository.findAll();
    }
}
