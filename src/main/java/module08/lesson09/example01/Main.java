package module08.lesson09.example01;

public class Main {

    public static void main(String[] args) {
        for (EnrollmentStatus status : EnrollmentStatus.values()) {
            System.out.println(status + ": active " + status.isActive()
                    + ", terminal " + status.isTerminal());
        }
    }
}

enum EnrollmentStatus {

    PENDING, ACTIVE, CANCELLED, COMPLETED;

    public boolean isActive() {
        return this == ACTIVE;
    }

    public boolean isTerminal() {
        return this == CANCELLED || this == COMPLETED;
    }
}
