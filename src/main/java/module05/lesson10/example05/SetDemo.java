package module05.lesson10.example05;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<String> genres = new LinkedHashSet<>();
        System.out.println(genres.add("Fantasy"));
        System.out.println(genres.add("History"));
        System.out.println(genres.add("Fantasy"));
        System.out.println(genres.add("fantasy"));
        System.out.println(genres);
    }
}
