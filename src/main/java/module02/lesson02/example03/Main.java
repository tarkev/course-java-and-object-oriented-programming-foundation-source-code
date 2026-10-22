package module02.lesson02.example03;

public class Main {

    public static void main(String[] args) {
        int score = 70;
        addBonus(score);
        System.out.println(score);

        score = addBonus(score);
        System.out.println(score);
    }

    static int addBonus(int score) {
        score = score + 10;
        return score;
    }
}
