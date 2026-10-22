package module02.lesson04.example06;

public class Main {

    public static void main(String[] args) {
        int[] original = {10, 20, 30};
        int[] copy = original;

        copy[0] = 99;
        System.out.println(original[0]);
    }
}
