package module01.lesson24.example02;

public class Main {

    public static void main(String[] args) {
        int age = 20;
        boolean emailVerified = true;
        boolean accountBlocked = false;
        boolean enrollmentOpen = true;

        boolean canEnroll = age >= 18 && emailVerified && !accountBlocked
                && enrollmentOpen;
        System.out.println("Can enroll: " + canEnroll);
    }
}
