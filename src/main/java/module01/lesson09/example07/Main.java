package module01.lesson09.example07;

public class Main {

    public static void main(String[] args) {
        int originalScore = 5;
        int copiedScore = originalScore;
        originalScore = 10;

        System.out.println(originalScore);
        System.out.println(copiedScore);
    }
}
