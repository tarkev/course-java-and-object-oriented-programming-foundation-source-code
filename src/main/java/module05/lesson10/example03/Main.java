package module05.lesson10.example03;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReadingClub club = new ReadingClub();
        club.join("Subu");
    }
}

class ReadingClub {

    private final List<String> members = List.of();

    void join(String name) {
        members.add(name);
    }
}
