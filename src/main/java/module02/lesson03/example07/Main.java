package module02.lesson03.example07;

public class Main {

    static int count = 5;

    public static void main(String[] args) {
        int count = 1;
        count++;
        System.out.println(count);
        printCount();
    }

    static void printCount() {
        System.out.println(count);
    }
}
