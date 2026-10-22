package module01.lesson10.example02;

public class Main {

    public static void main(String[] args) {
        int maximum = 2_147_483_647;
        int nextInt = maximum + 1;
        long nextLong = maximum + 1L;

        System.out.println(nextInt);
        System.out.println(nextLong);
    }
}
