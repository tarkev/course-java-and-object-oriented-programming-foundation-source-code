package module11.lesson10.tests.learner.storage;

import module11.lesson10.tests.learner.EmailAddress;
import module11.lesson10.tests.learner.Learner;
import module11.lesson10.tests.learner.LearnerId;
import module11.lesson10.tests.learner.LearnerRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class InMemoryLearnerRepository implements LearnerRepository {

    private final Map<LearnerId, Learner> learners = new LinkedHashMap<>();

    @Override
    public void save(Learner learner) {
        if (learner == null) {
            throw new IllegalArgumentException("Learner is required.");
        }

        learners.put(learner.id(), learner);
    }

    @Override
    public Optional<Learner> findById(LearnerId learnerId) {
        if (learnerId == null) {
            throw new IllegalArgumentException("Learner id is required.");
        }

        return Optional.ofNullable(learners.get(learnerId));
    }

    @Override
    public Optional<Learner> findByEmail(EmailAddress email) {
        if (email == null) {
            throw new IllegalArgumentException("Email is required.");
        }

        return learners.values()
                .stream()
                .filter(learner -> learner.email().equals(email))
                .findFirst();
    }

    @Override
    public List<Learner> findAll() {
        return List.copyOf(learners.values());
    }
}
