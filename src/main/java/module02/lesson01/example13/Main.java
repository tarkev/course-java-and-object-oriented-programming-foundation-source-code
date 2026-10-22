package module02.lesson01.example13;

public class Main {

    public static void main(String[] args) {
        lesson();
        quiz();
        lesson();
    }

    static void lesson() {
        System.out.println("Watch");
        quiz();
    }

    static void quiz() {
        System.out.println("Answer");
    }
}
