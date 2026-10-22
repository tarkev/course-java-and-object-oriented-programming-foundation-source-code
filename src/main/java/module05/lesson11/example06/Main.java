package module05.lesson11.example06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Nur");
        names.add(null);
        names.add("   ");
        names.add("Al");
        names.add("Sumu");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name == null || name.isBlank() || name.length() < 3) {
                iterator.remove();
            }
        }

        System.out.println(names);
    }
}
