package module05.lesson10.example09;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> roles = new HashSet<>();
        roles.add("LEARNER");
        roles.add("INSTRUCTOR");
        roles.add("LEARNER");
        roles.add("CONTENT_EDITOR");
        System.out.println(roles.size());
    }
}
