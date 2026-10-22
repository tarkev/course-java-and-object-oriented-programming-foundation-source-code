package module03.lesson13.example02;

public class Main {

    public static void main(String[] args) {
        Enrollment enrollment = new Enrollment();
        enrollment.learnerName = "Sakib";
        enrollment.completedLessons = 18;
        enrollment.totalLessons = 20;

        System.out.println("Learner: " + enrollment.learnerName);
        System.out.println(
                "Progress: " + enrollment.calculateProgress() + "%");
        System.out.println("Completed: " + enrollment.isCompleted());
    }
}

class Enrollment {

    String learnerName;
    int completedLessons;
    int totalLessons;

    double calculateProgress() {
        if (totalLessons <= 0) {
            return 0.0;
        }

        return completedLessons * 100.0 / totalLessons;
    }

    boolean isCompleted() {
        return totalLessons > 0 && completedLessons == totalLessons;
    }
}
