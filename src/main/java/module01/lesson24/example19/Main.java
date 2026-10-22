package module01.lesson24.example19;

public class Main {

    public static void main(String[] args) {
        int age = 17;
        boolean emailVerified = true;
        boolean enrollmentOpen = true;
        boolean accountBlocked = false;

        if (age < 18) {
            System.out.println("Minimum age requirement not met");
        } else if (!emailVerified) {
            System.out.println("Email verification required");
        } else if (!enrollmentOpen) {
            System.out.println("Enrollment is closed");
        } else if (accountBlocked) {
            System.out.println("Blocked account cannot enroll");
        } else {
            System.out.println("Enrollment allowed");
        }
    }
}
