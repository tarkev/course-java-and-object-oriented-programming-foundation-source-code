package module06.lesson12.example06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<String> emails = List.of(
                "sakib@example.com", "nur@example.com", "Sakib@example.com",
                "subu@example.com", "nur@example.com", "sakib@example.com",
                "sumu@example.com");

        Map<String, Integer> duplicates = duplicateEmails(emails);
        System.out.println(duplicates);

        int extraCopies = 0;
        for (int count : duplicates.values()) {
            extraCopies += count - 1;
        }
        System.out.println("Extra copies: " + extraCopies);
    }

    static Map<String, Integer> duplicateEmails(List<String> emails) {
        Map<String, Integer> counts = new HashMap<>();

        for (String email : emails) {
            counts.merge(email.toLowerCase(), 1, Integer::sum);
        }

        Map<String, Integer> duplicates = new HashMap<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.put(entry.getKey(), entry.getValue());
            }
        }

        return duplicates;
    }
}
