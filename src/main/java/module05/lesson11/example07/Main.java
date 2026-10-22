package module05.lesson11.example07;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static Learner findLearnerById(List<Learner> learners, long learnerId) {
        if (learners == null) {
            return null;
        }
        for (Learner learner : learners) {
            if (learner != null && learner.getId() == learnerId) {
                return learner;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Learner> learners = new ArrayList<>();
        learners.add(new Learner(1L, "Sakib"));
        learners.add(null);
        learners.add(new Learner(2L, "Jalisa"));

        System.out.println(findLearnerById(learners, 2L).getName());
        System.out.println(findLearnerById(learners, 3L));
    }
}

final class Learner {
    private final long id;
    private final String name;

    Learner(long id, String name) {
        this.id = id;
        this.name = name;
    }

    long getId() {
        return id;
    }

    String getName() {
        return name;
    }
}
