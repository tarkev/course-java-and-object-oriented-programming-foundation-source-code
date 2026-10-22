package module01.lesson24.example18;

public class Main {

    public static void main(String[] args) {
        boolean userExists = true;
        boolean passwordCorrect = false;
        boolean accountLocked = false;

        if (!userExists) {
            System.out.println("User not found");
        } else if (accountLocked) {
            System.out.println("Account locked");
        } else if (!passwordCorrect) {
            System.out.println("Incorrect password");
        } else {
            System.out.println("Login successful");
        }
    }
}
