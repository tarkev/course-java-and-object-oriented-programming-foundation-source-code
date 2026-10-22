package module03.lesson04.example02;

public class Workshop {

    String title;
    int seats;

    Workshop(String title, int seats) {
        this.title = title;
        this.seats = seats;
    }

    void changeSeats(int seats) {
        if (seats > 0) {
            seats = seats;
        }
    }

    public static void main(String[] args) {
        Workshop workshop = new Workshop("Java Basics", 20);
        workshop.changeSeats(30);
        System.out.println(workshop.seats);
    }
}
