package module01.lesson13.example01;

public class Main {

    public static void main(String[] args) {
        String ageInput = "30";
        String scoreInput = "85.5";
        String activeInput = "true";

        int age = Integer.parseInt(ageInput);
        double score = Double.parseDouble(scoreInput);
        boolean active = Boolean.parseBoolean(activeInput);

        System.out.println("Age next year: " + (age + 1));
        System.out.println("Score: " + score);
        System.out.println("Active: " + active);
    }
}
