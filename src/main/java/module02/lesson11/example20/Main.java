package module02.lesson11.example20;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] learners = {"Sakib", "Nur", "Subu", "Sumu"};
        String[] courses = {"Java", "SQL", "Git", "Web"};
        int[][] scores = {{80, 90, 85, 85}, {70, 95, 87, 78}, {91, 80, 96, 88}, {60, 75, 72, 92}};

        double[] averages = averages(scores);

        for (int row = 0; row < scores.length; row++) {
            System.out.print(learners[row] + ":");
            for (int score : scores[row]) {
                System.out.print(" " + score);
            }
            System.out.println(" | average " + averages[row]);
        }

        for (int column = 0; column < courses.length; column++) {
            int best = bestLearnerIndex(scores, column);
            System.out.println("Best in " + courses[column] + ": "
                    + learners[best] + " (" + scores[best][column] + ")");
        }

        double[] sorted = Arrays.copyOf(averages, averages.length);
        Arrays.sort(sorted);
        System.out.println("Averages, sorted: " + Arrays.toString(sorted));
        System.out.println("Averages, learner order: " + Arrays.toString(averages));
    }

    static double average(int[] row) {
        int total = 0;
        for (int score : row) {
            total += score;
        }
        return (double) total / row.length;
    }

    static double[] averages(int[][] scores) {
        double[] result = new double[scores.length];
        for (int row = 0; row < scores.length; row++) {
            result[row] = average(scores[row]);
        }
        return result;
    }

    static int bestLearnerIndex(int[][] scores, int column) {
        int best = 0;
        for (int row = 1; row < scores.length; row++) {
            if (scores[row][column] > scores[best][column]) {
                best = row;
            }
        }
        return best;
    }
}
