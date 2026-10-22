package module02.lesson05.example01;

public class Main {

    public static void main(String[] args) {
        int[] scores = {82, 91, 45, 76, 88};

        int total = sum(scores);
        double average = (double) total / scores.length;
        int highest = max(scores);
        int lowest = min(scores);
        int passing = countPassing(scores);

        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
        System.out.println("Passing: " + passing);
    }

    static int sum(int[] scores) {
        int total = 0;

        for (int score : scores) {
            total += score;
        }

        return total;
    }

    static int max(int[] scores) {
        int maximum = scores[0];

        for (int index = 1; index < scores.length; index++) {
            if (scores[index] > maximum) {
                maximum = scores[index];
            }
        }

        return maximum;
    }

    static int min(int[] scores) {
        int minimum = scores[0];

        for (int index = 1; index < scores.length; index++) {
            if (scores[index] < minimum) {
                minimum = scores[index];
            }
        }

        return minimum;
    }

    static int countPassing(int[] scores) {
        int count = 0;

        for (int score : scores) {
            if (score >= 60) {
                count++;
            }
        }

        return count;
    }
}
