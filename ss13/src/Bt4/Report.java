package Bt4;

public class Report {
    public static void generateReport(String name, int age, double[] scores) {
        printNameAndAge(name, age);
        double avg = calculateAverageScore(scores);
        printAverageScore(avg);
        printGrade(avg);
    }

    private static void printNameAndAge(String name, int age) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    private static double calculateAverageScore(double[] scores) {
        double total = 0;
        for (double score : scores) {
            total += score;
        }
        return total / scores.length;
    }

    private static void printAverageScore(double avg) {
        System.out.println("Average Score: " + avg);
    }

    private static void printGrade(double avg) {
        if (avg >= 8) {
            System.out.println("Grade: Excellent");
        } else if (avg >= 5) {
            System.out.println("Grade: Good");
        } else {
            System.out.println("Grade: Fail");
        }
    }
}
