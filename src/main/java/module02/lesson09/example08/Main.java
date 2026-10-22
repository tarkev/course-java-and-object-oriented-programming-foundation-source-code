package module02.lesson09.example08;

public class Main {

    public static void main(String[] args) {
        System.out.println(isAdult(20));
        System.out.println(isAdult(18));
        System.out.println(isAdult(15));
    }

    static boolean isAdult(int age) {
        return age >= 18;
    }
}
