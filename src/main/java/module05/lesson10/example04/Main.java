package module05.lesson10.example04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> learners = new ArrayList<>();
        learners.add("Subu");
        learners.add("Sumu");
        learners.add(1, "Nur");
        learners.set(learners.size() - 1, "Jalisa");
        learners.remove("Nur");

        for (int i = 0; i < learners.size(); i++) {
            System.out.println(i + ": " + learners.get(i));
        }
    }
}
