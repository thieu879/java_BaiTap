package ra.validate;

import java.util.Scanner;

public class Validate {
    public static String validateString(Scanner sc, String fieldName, int maxLength) {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(fieldName + " không được để trống!");
                System.out.print("Nhập lại: ");
                continue;
            }
            if (input.length() > maxLength) {
                System.out.println(fieldName + " không được vượt quá " + maxLength + " ký tự!");
                System.out.print("Nhập lại: ");
                continue;
            }
            return input;
        }
    }

    public static int validateInt(Scanner sc, String fieldName, int minValue) {
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input <= minValue) {
                    System.out.println(fieldName + " phải lớn hơn " + minValue + "!");
                    System.out.print("Nhập lại: ");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ cho " + fieldName + "!");
                System.out.print("Nhập lại: ");
            }
        }
    }

    public static double validateDouble(Scanner sc, String fieldName, double minValue) {
        while (true) {
            try {
                double input = Double.parseDouble(sc.nextLine());
                if (input <= minValue) {
                    System.out.println(fieldName + " phải lớn hơn " + minValue + "!");
                    System.out.print("Nhập lại: ");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ cho " + fieldName + "!");
                System.out.print("Nhập lại: ");
            }
        }
    }
}