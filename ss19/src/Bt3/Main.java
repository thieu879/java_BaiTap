package Bt3;

import java.util.Scanner;
import java.util.function.BiFunction;
import Bt3.MathOperations;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số thứ nhất (a): ");
        int a = scanner.nextInt();
        System.out.print("Nhập số thứ hai (b): ");
        int b = scanner.nextInt();

        BiFunction<Integer, Integer, Integer> add = MathOperations::add;
        BiFunction<Integer, Integer, Integer> subtract = MathOperations::subtract;
        BiFunction<Integer, Integer, Integer> multiply = MathOperations::multiply;
        BiFunction<Integer, Integer, Integer> divide = MathOperations::divide;

        System.out.println("Kết quả phép cộng: " + add.apply(a, b));
        System.out.println("Kết quả phép trừ: " + subtract.apply(a, b));
        System.out.println("Kết quả phép nhân: " + multiply.apply(a, b));
        System.out.println("Kết quả phép chia: " + divide.apply(a, b));

        System.out.println(add.apply(a, b));
        System.out.println(subtract.apply(a, b));
        System.out.println(multiply.apply(a, b));
        System.out.println(divide.apply(a, b));
    }
}
