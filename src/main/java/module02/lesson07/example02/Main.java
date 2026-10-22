package module02.lesson07.example02;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] scores = {82, 91, 76, 88, 69};
        System.out.println("Original: " + Arrays.toString(scores));

        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);
        System.out.println("Sorted: " + Arrays.toString(sortedScores));

        boolean found = Arrays.binarySearch(sortedScores, 88) >= 0;
        System.out.println("Contains 88: " + found);
        System.out.println("Original: " + Arrays.toString(scores));
    }
}
