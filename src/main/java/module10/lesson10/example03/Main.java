package module10.lesson10.example03;

public class Main {

    public static void main(String[] args) {
        int[][] scores = {{80, 90}, {70, 60}};
        ScoreTable table = new ScoreTable(scores);

        scores[0][0] = 10;
        table.getScores()[1][0] = 10;

        System.out.println(table.scoreAt(0, 0) + " " + table.scoreAt(1, 0));
    }
}

final class ScoreTable {

    private final int[][] scores;

    ScoreTable(int[][] scores) {
        if (scores == null) {
            throw new IllegalArgumentException("Scores are required.");
        }

        this.scores = deepCopy(scores);
    }

    int[][] getScores() {
        return deepCopy(scores);
    }

    int scoreAt(int row, int column) {
        return scores[row][column];
    }

    private static int[][] deepCopy(int[][] source) {
        int[][] copy = new int[source.length][];

        for (int row = 0; row < source.length; row++) {
            if (source[row] == null) {
                throw new IllegalArgumentException("Rows cannot be null.");
            }

            copy[row] = source[row].clone();
        }

        return copy;
    }
}
