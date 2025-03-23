package Ra.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class validateStudent {
    public static String getNonEmptyString(Scanner sc, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Không được để trống!");
            }
        } while (input.isEmpty());
        return input;
    }

    public static String getValidDate(Scanner sc, String prompt) {
        String date;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        do {
            System.out.print(prompt);
            date = sc.nextLine().trim();
            try {
                sdf.parse(date);
                return date;
            } catch (ParseException e) {
                System.out.println("Định dạng ngày không hợp lệ (dd/MM/yyyy)!");
            }
        } while (true);
    }

    public static String getValidPhoneNumber(Scanner sc, String prompt) {
        String phone;
        String regex = "^(03|05|07|08|09)\\d{8}$";
        do {
            System.out.print(prompt);
            phone = sc.nextLine().trim();
            if (!Pattern.matches(regex, phone)) {
                System.out.println("Số điện thoại không hợp lệ (VD: 0912345678)!");
            } else {
                return phone;
            }
        } while (true);
    }

    public static boolean getBoolean(Scanner sc, String prompt) {
        System.out.print(prompt);
        return Boolean.parseBoolean(sc.nextLine().trim());
    }

    public static String getValidEmail(Scanner sc, String prompt) {
        String email;
        String regex = "^[\\w-.]+@gmail\\.com$";
        do {
            System.out.print(prompt);
            email = sc.nextLine().trim();
            if (!Pattern.matches(regex, email)) {
                System.out.println("Email không hợp lệ (VD: example@gmail.com)!");
            } else {
                return email;
            }
        } while (true);
    }

    public static float getValidGpa(Scanner sc, String prompt) {
        float gpa;
        do {
            System.out.print(prompt);
            try {
                gpa = Float.parseFloat(sc.nextLine().trim());
                if (gpa >= 0) return gpa;
                System.out.println("GPA phải lớn hơn hoặc bằng 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        } while (true);
    }
}