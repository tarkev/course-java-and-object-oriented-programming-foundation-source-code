// Generated from modules/06-algorithms-and-problem-solving-with-java/05-java-s-built-in-sorting-and-searching-apis.md by tools/extract_code.py. Edit the lesson, not this file.
package module06.lesson05.example02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Learner> learners = new ArrayList<>(List.of(
                new Learner("Sakib", 91),
                new Learner("Subu", 95),
                new Learner("Sumu", 95),
                new Learner("Nur", 88)));

        Comparator<Learner> ranking =
                Comparator.comparingInt(Learner::getScore)
                        .reversed()
                        .thenComparing(Learner::getName);

        learners.sort(ranking);

        for (Learner learner : learners) {
            System.out.println(learner.getName() + " - " + learner.getScore());
        }
    }
}
