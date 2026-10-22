package module02.lesson04.example04;

public class Main {

    public static void main(String[] args) {
        int[] scores = {80, 90, 75, 60};
        scores[scores.length - 1] = scores[0] + 5;

        System.out.println(scores.length);
        System.out.println(scores[3]);
    }
}
