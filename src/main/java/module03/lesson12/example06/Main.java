package module03.lesson12.example06;

public class Main {

    public static void main(String[] args) {
        System.out.println(Learner.getTotalLearnersCreated());

        new Learner("Nur");
        new Learner("Subu");
        new Learner("Sumu");

        System.out.println(Learner.getTotalLearnersCreated());
    }
}

class Learner {

    private static int totalLearnersCreated;

    private String name;

    public Learner(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Learner name is required.");
        }

        this.name = name.strip();
        totalLearnersCreated++;
    }

    public static int getTotalLearnersCreated() {
        return totalLearnersCreated;
    }
}
