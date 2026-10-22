package module05.lesson11.example16;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> countryNames = new LinkedHashMap<>();
        countryNames.put("BD", "Bangladesh");
        countryNames.put("EE", "Estonia");
        countryNames.put("UK", "United Kingdom");
        countryNames.put("GB", "United Kingdom");

        Map<String, String> codesByName = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : countryNames.entrySet()) {
            String existing =
                    codesByName.putIfAbsent(entry.getValue(), entry.getKey());
            if (existing != null) {
                System.out.println("Clash: " + entry.getValue()
                        + " already maps to " + existing
                        + ", skipping " + entry.getKey());
            }
        }

        System.out.println(codesByName);
        System.out.println(codesByName.get("Estonia"));
    }
}
