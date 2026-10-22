package module05.lesson12.example10;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> statuses = List.of(
                "ACTIVE", "CANCELLED", "ACTIVE", "PENDING", "ACTIVE");
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String status : statuses) {
            counts.put(status, counts.getOrDefault(status, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
