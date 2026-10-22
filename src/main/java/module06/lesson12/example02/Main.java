package module06.lesson12.example02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of(
                "Java", List.of("OOP", "Algorithms"),
                "OOP", List.of("Design Patterns", "Algorithms"),
                "Algorithms", List.of("Java", "Data Structures"),
                "Data Structures", List.of(),
                "Design Patterns", List.of("OOP"));

        System.out.println(breadthFirst(graph, "Java"));
        System.out.println(breadthFirst(graph, "Design Patterns"));
        System.out.println(breadthFirst(graph, "Data Structures"));
    }

    static List<String> breadthFirst(Map<String, List<String>> graph, String start) {
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);

            for (String neighbor : graph.get(current)) {
                if (visited.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }

        return order;
    }
}
