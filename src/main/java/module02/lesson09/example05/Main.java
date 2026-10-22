package module02.lesson09.example05;

public class Main {

    public static void main(String[] args) {
        int score = 80;
        addBonus(score);
        System.out.println(score);
        score = addBonus(score);
        System.out.println(score);
    }

    static int addBonus(int score) {
        score += 5;
        return score;
    }
}
