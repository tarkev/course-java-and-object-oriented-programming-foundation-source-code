package module01.lesson23.example23;

public class Main {

    public static void main(String[] args) {
        int option = 2;

        switch (option) {
            case 1 -> System.out.println("Creating a course");
            case 2 -> System.out.println("Viewing courses");
            case 3 -> System.out.println("Updating a course");
            case 4 -> System.out.println("Exiting");
            default -> System.out.println("Invalid option");
        }
    }
}
