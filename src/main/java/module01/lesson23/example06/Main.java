package module01.lesson23.example06;

public class Main {

    public static void main(String[] args) {
        int age = 30;
        double score = 85.5;
        boolean active = true;
        char grade = 'A';

        String ageText = String.valueOf(age);
        String scoreText = String.valueOf(score);
        String activeText = String.valueOf(active);
        String gradeText = String.valueOf(grade);

        System.out.println(ageText + " " + scoreText + " " + activeText
                + " " + gradeText);
    }
}
