package Bt1;

public class MultiplicationSumCalculator  {
    public static void main(String[] args) {
        int firstNumber = 5;
        int secondNumber = 10;
        int result = calculateMultiplicationAndSum(firstNumber, secondNumber);
        System.out.println("Kết quả: " + result);
    }

    public static int calculateMultiplicationAndSum(int num1, int num2) {
        return (num1 * num2) + (num1 + num2);
    }
}