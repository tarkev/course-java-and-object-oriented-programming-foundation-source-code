package module05.lesson10.example13;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] tags = {"java", "backend", "java", "spring", "backend", "java"};
        Map<String, Integer> tagCounts = new LinkedHashMap<>();

        for (String tag : tags) {
            tagCounts.put(tag, tagCounts.getOrDefault(tag, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : tagCounts.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
