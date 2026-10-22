package module02.lesson03.example08;

public class Main {

    static int total = 0;

    public static void main(String[] args) {
        visit();
        visit();
        visit();
        System.out.println("Total: " + total);
    }

    static void visit() {
        int calls = 0;
        calls++;
        total++;
        System.out.println("Calls: " + calls);
    }
}
