package Bt2;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Tổng 2 số (5 + 10) = " + calculator.add(5, 10));

        System.out.println("Tổng 3 số (3 + 7 + 2) = " + calculator.add(3, 7, 2));
    }
}
