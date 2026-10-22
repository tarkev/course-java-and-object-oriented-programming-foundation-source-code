package module06.lesson10.example09;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Long, String> learners = new HashMap<>();
        learners.put(100L, "Sakib");

        System.out.println(learners.get(100L));
        System.out.println(learners.get(200L));
    }
}
