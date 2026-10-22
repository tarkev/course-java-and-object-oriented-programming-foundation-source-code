package module07.lesson16.example14;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> progressByLearner = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Integer> learnersByState = new ConcurrentHashMap<>();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int number = 1; number <= 1_000; number++) {
                int learnerNumber = number;
                executor.submit(() -> {
                    Thread.sleep(10);
                    int progress = learnerNumber * 7 % 101;
                    progressByLearner.put("learner-" + learnerNumber, progress);
                    String state = progress >= 80 ? "completed" : "in progress";
                    learnersByState.merge(state, 1, Integer::sum);
                    return progress;
                });
            }
        }

        System.out.println("Learners: " + progressByLearner.size());
        System.out.println("learner-42: " + progressByLearner.get("learner-42") + "%");
        System.out.println(learnersByState);
    }
}
