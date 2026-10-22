package module03.lesson12.example01;

class SeatTicket {

    private static int issued;
    private final int number;

    SeatTicket() {
        issued++;
        number = issued;
    }

    int getNumber() {
        return number;
    }

    static int getIssued() {
        return issued;
    }
}

public class SeatTicketDemo {

    public static void main(String[] args) {
        SeatTicket first = new SeatTicket();
        SeatTicket second = new SeatTicket();
        SeatTicket third = second;
        System.out.println(first.getNumber() + " " + third.getNumber());
        System.out.println(SeatTicket.getIssued());
    }
}
