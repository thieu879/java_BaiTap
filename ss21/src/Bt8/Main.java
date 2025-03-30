package Bt8;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> validPhoneNumbers = new ArrayList<>();
        System.out.println("Nhập danh sách số điện thoại (cách nhau bằng dấu phẩy): ");
        String input = scanner.nextLine();
        String[] phoneNumbers = input.split(",");
        for (String phone : phoneNumbers) {
            // Loại bỏ khoảng trắng
            phone = phone.trim();

            try {
                // Kiểm tra tính hợp lệ của số điện thoại
                validatePhoneNumber(phone);
                // Nếu không có ngoại lệ, số điện thoại hợp lệ
                validPhoneNumbers.add(phone);
                System.out.println("Số " + phone + " hợp lệ.");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (InvalidPhoneNumberLengthException e) {
                System.out.println(e.getMessage());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void validatePhoneNumber(String phoneNumber)
            throws NumberFormatException, InvalidPhoneNumberLengthException {
        if (phoneNumber.length() != 10) {
            throw new InvalidPhoneNumberLengthException(
                    "Lỗi: Số điện thoại phải có đúng 10 ký tự!"
            );
        }

        for (char c : phoneNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new NumberFormatException(
                        "Lỗi: Số điện thoại chỉ được chứa chữ số!"
                );
            }
        }
    }
}
