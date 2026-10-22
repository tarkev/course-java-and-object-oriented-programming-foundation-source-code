package module08.lesson09.example10;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> scores = List.of("85", "ninety");
        System.out.println(readScore(scores, 0));
        System.out.println(readScore(scores, 1));
        System.out.println(readScore(scores, 5));
        System.out.println(readScoreMultiCatch(scores, 1));
        System.out.println(readScoreMultiCatch(scores, 5));
    }

    static String readScore(List<String> scores, int index) {
        try {
            return "Score: " + Integer.parseInt(scores.get(index));
        } catch (IndexOutOfBoundsException exception) {
            return "There is no score at position " + index + ".";
        } catch (NumberFormatException exception) {
            return "The score at position " + index + " is not a number.";
        }
    }

    static String readScoreMultiCatch(List<String> scores, int index) {
        try {
            return "Score: " + Integer.parseInt(scores.get(index));
        } catch (IndexOutOfBoundsException | NumberFormatException exception) {
            return "The score at position " + index + " could not be read.";
        }
    }
}
