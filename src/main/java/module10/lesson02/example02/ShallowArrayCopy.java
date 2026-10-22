package module10.lesson02.example02;

public class ShallowArrayCopy {

    public static void main(String[] args) {
        int[][] scores = {{80, 90}, {70, 60}};
        int[][] copy = scores.clone();

        copy[0][0] = 10;
        copy[1] = new int[] {100, 100};

        System.out.println(scores[0][0]);
        System.out.println(scores[1][0]);
    }
}
