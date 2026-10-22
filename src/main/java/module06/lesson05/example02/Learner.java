package module06.lesson05.example02;

public final class Learner {

    private final String name;
    private final int score;

    public Learner(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
