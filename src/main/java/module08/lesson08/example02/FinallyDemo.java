package module08.lesson08.example02;

public class FinallyDemo {

    static int availableSeats() {
        try {
            System.out.println("Checking room");
            throw new IllegalStateException("Room is closed.");
        } finally {
            System.out.println("Closing check");
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Seats: " + availableSeats());
    }
}
