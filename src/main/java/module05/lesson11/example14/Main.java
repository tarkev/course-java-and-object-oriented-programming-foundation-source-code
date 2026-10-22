package module05.lesson11.example14;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String[] learners = {"Nur", "Sakib", "Nur", "Jalisa", "Sakib"};
        int[] minutes = {30, 20, 15, 40, 10};
        Map<String, Integer> minutesByLearner = new TreeMap<>();

        for (int i = 0; i < learners.length; i++) {
            String learner = learners[i];
            minutesByLearner.put(learner,
                    minutesByLearner.getOrDefault(learner, 0) + minutes[i]);
        }

        for (Map.Entry<String, Integer> entry : minutesByLearner.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
