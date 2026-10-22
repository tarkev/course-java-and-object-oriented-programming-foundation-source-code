package module02.lesson06.example01;

public class Main {

    public static void main(String[] args) {
        int[][] scores = {{80, 90, 85}, {75, 88, 92}, {91, 84, 89}};

        printScores(scores);

        for (int student = 0; student < scores.length; student++) {
            System.out.println(
                    "Student " + (student + 1) + " average: " + average(scores[student]));
        }
    }

    static void printScores(int[][] scores) {
        for (int[] row : scores) {
            for (int score : row) {
                System.out.print(score + " ");
            }

            System.out.println();
        }
    }

    static double average(int[] values) {
        int total = 0;

        for (int value : values) {
            total += value;
        }

        return (double) total / values.length;
    }
}
