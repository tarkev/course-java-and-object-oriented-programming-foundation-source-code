package module01.lesson15.example01;

public class Main {

    public static void main(String[] args) {
        int learnerAge = 20;
        boolean emailVerified = true;
        boolean enrollmentOpen = true;
        boolean accountBlocked = false;

        if (learnerAge < 0) {
            System.out.println("Invalid age");
        } else if (learnerAge < 18) {
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
