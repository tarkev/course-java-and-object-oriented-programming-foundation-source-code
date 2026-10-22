package module10.lesson03.example04.course;

import java.util.HashMap;
import java.util.Map;

public class MutableKeyDemo {

    static class MutableCourseCode {

        private String value;

        MutableCourseCode(String value) {
            this.value = value;
        }

        void setValue(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object other) {
            return other instanceof MutableCourseCode code && value.equals(code.value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }

    public static void main(String[] args) {
        Map<MutableCourseCode, String> titles = new HashMap<>();
        MutableCourseCode code = new MutableCourseCode("JAVA");
        titles.put(code, "Java Foundation");

        code.setValue("BACKEND");

        System.out.println(titles.get(code));
        System.out.println(titles.get(new MutableCourseCode("JAVA")));
        System.out.println(titles.containsKey(code));
        System.out.println(titles.remove(code));
        System.out.println(titles.size());
    }
}
