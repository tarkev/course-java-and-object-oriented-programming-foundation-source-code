package module05.lesson10.example12;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> countryNames = new HashMap<>();
        countryNames.put("BD", "Bangladesh");
        countryNames.put("EE", "Estonia");
        countryNames.put("FI", "Finland");

        System.out.println(countryNames.get("EE"));
        System.out.println(countryNames.containsKey("SE"));
        System.out.println(countryNames.getOrDefault("SE", "Unknown"));
        countryNames.remove("FI");
        System.out.println(countryNames.size());
    }
}
