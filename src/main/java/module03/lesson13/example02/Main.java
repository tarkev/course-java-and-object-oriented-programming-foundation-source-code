package module03.lesson13.example02;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Learner first = new Learner(1L, "Nur", "nur@example.com");
        Learner second = new Learner(1L, "Nur Islam", "nur@tarkev.com");
        Learner third = new Learner(2L, "Nur", "nur@example.com");

        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());
        System.out.println(first.equals(third));
        System.out.println(first);
    }
}

class Learner {

    private final long learnerId;
    private final String name;
    private final String email;

    Learner(long learnerId, String name, String email) {
        this.learnerId = learnerId;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Learner learner = (Learner) other;
        return learnerId == learner.learnerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(learnerId);
    }

    @Override
    public String toString() {
        return "Learner{" + "learnerId=" + learnerId
                + ", name='" + name + '\'' + '}';
    }
}
