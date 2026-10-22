package module06.lesson11.example02;

public class Main {

    public static void main(String[] args) {
        Course[] courses = {
            new Course("Spring Boot", 2000),
            new Course("Java Basics", 1500),
            new Course("Docker", 1200),
            new Course("Java Basics", 900),
            new Course("Algorithms", 1800)
        };

        insertionSortByTitle(courses);

        for (Course course : courses) {
            System.out.println(course.getTitle() + " " + course.getPrice());
        }
    }

    static void insertionSortByTitle(Course[] courses) {
        for (int i = 1; i < courses.length; i++) {
            Course current = courses[i];
            int position = i - 1;

            while (position >= 0
                    && courses[position].getTitle().compareTo(current.getTitle()) > 0) {
                courses[position + 1] = courses[position];
                position--;
            }

            courses[position + 1] = current;
        }
    }
}

class Course {
    private final String title;
    private final long price;

    Course(String title, long price) {
        this.title = title;
        this.price = price;
    }

    String getTitle() {
        return title;
    }

    long getPrice() {
        return price;
    }
}
