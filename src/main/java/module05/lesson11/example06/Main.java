package module05.lesson11.example06;

import java.util.List;

public class Main {

    static boolean containsLearner(
            List<String> learners, String learnerName) {
        if (learners == null || learnerName == null) {
            return false;
        }
        return learners.contains(learnerName);
    }

    public static void main(String[] args) {
        List<String> learners = List.of("Nur", "Sumu");
        System.out.println(containsLearner(learners, "Sumu"));
        System.out.println(containsLearner(learners, "Jalisa"));
        System.out.println(containsLearner(null, "Nur"));
        System.out.println(containsLearner(learners, null));
    }
}
