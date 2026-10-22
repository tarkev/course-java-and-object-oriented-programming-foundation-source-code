package module03.lesson12.example03;

import java.util.Arrays;

class ScoreBoard {

    private final int[] scores;

    ScoreBoard(int[] scores) {
        this.scores = Arrays.copyOf(scores, scores.length);
    }

    int[] getScores() {
        return Arrays.copyOf(scores, scores.length);
    }
}

public class ScoreBoardDemo {

    public static void main(String[] args) {
        int[] scores = {70, 80};
        ScoreBoard board = new ScoreBoard(scores);
        scores[0] = 0;
        board.getScores()[1] = 0;
        int[] current = board.getScores();
        System.out.println(current[0] + current[1]);
    }
}
