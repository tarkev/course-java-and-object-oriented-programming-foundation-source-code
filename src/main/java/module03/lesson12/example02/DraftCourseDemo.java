package module03.lesson12.example02;

class DraftCourse {

    private String title = "Untitled";

    DraftCourse(String title) {
        title = title;
    }

    String getTitle() {
        return title;
    }
}

public class DraftCourseDemo {

    public static void main(String[] args) {
        DraftCourse course = new DraftCourse("Java Basics");
        System.out.println(course.getTitle());
    }
}
