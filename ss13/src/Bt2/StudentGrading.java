package Bt2;

public class StudentGrading  {
    public static void main(String[] args) {
        double[] studentMarks = {7.5, 8.0, 6.5};
        double averageScore = calculateAverage(studentMarks);

        if (averageScore > 5) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public static double calculateAverage(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total / marks.length;
    }
}
