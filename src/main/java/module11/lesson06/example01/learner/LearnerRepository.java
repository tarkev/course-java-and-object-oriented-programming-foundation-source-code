package module11.lesson06.example01.learner;

import java.util.List;
import java.util.Optional;

public interface LearnerRepository {

    void save(Learner learner);

    Optional<Learner> findById(LearnerId learnerId);

    Optional<Learner> findByEmail(EmailAddress email);

    List<Learner> findAll();
}
