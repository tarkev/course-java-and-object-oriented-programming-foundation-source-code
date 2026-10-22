package module05.lesson10.example07;

import java.util.Map;
import java.util.TreeMap;

public class CountDemo {

    public static void main(String[] args) {
        String[] loans = {"Nur", "Sakib", "Nur", "Jalisa", "Nur"};
        Map<String, Integer> loansByMember = new TreeMap<>();

        for (String member : loans) {
            loansByMember.put(member, loansByMember.getOrDefault(member, 0) + 1);
        }

        System.out.println(loansByMember);
        System.out.println(loansByMember.get("Subu"));
    }
}
