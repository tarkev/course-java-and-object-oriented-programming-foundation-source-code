package module06.lesson11.example10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Sumu", "Sakib", "Nur"));

        names.sort(Comparator.naturalOrder());

        System.out.println(names);
    }
}
