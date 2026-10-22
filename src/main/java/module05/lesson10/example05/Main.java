package module05.lesson10.example05;

import java.util.List;

public class Main {

    static String getLearnerOrDefault(
            List<String> learners, int index, String defaultValue) {
        if (learners == null || index < 0 || index >= learners.size()) {
            return defaultValue;
        }
        return learners.get(index);
    }

    public static void main(String[] args) {
        List<String> learners = List.of("Nur", "Subu");
        System.out.println(getLearnerOrDefault(learners, 1, "Unknown"));
        System.out.println(getLearnerOrDefault(learners, 2, "Unknown"));
        System.out.println(getLearnerOrDefault(learners, -1, "Unknown"));
        System.out.println(getLearnerOrDefault(null, 0, "Unknown"));
    }
}
