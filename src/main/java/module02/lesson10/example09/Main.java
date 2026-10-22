package module02.lesson10.example09;

public class Main {

    public static void main(String[] args) {
        System.out.println(max(7, 12));
        System.out.println(max(25, 3));
        System.out.println(max(9, 9));
    }

    static int max(int first, int second) {
        if (first > second) {
            return first;
        }
        return second;
    }
}
