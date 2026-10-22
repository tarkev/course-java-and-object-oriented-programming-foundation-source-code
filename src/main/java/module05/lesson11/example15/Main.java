package module05.lesson11.example15;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] learners = {"Sakib", "Nur", "Subu", "Sumu", "Nur"};
        String[] courses = {"JAVA", "SPRING", "JAVA", "SQL", "JAVA"};
        Map<String, List<String>> learnersByCourse = new LinkedHashMap<>();

        for (int i = 0; i < courses.length; i++) {
            List<String> group = learnersByCourse.get(courses[i]);
            if (group == null) {
                group = new ArrayList<>();
                learnersByCourse.put(courses[i], group);
            }
            group.add(learners[i]);
        }

        for (Map.Entry<String, List<String>> entry : learnersByCourse.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
