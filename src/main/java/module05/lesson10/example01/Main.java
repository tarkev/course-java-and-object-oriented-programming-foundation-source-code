package module05.lesson10.example01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> waiting = new ArrayList<>(List.of("Sakib", "Nur", "Sumu"));

        for (String member : waiting) {
            if (member.startsWith("S")) {
                waiting.remove(member);
            }
        }

        System.out.println(waiting);
    }
}
