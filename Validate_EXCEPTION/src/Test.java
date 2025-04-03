import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validator validator = new Validator();

        do {
            System.out.println("\nMenu");
            System.out.println("1. Kiểm tra kiểu số nguyên");
            System.out.println("2. Kiểm tra kiểu số thực float");
            System.out.println("3. Kiểm tra kiểu số thực double");
            System.out.println("4. Validate kiểu Boolean với giá trị nhập vào là true/false");
            System.out.println("5. Validate kiểu String (không rỗng, độ dài từ min đến max)");
            System.out.println("6. Validate kiểu email (phải đúng định dạng email)");
            System.out.println("7. Validate kiểu phone (phải đúng định dạng số điện thoại VN)");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue;
            }

            if (choice == 0) {
                System.out.println("Tạm biệt!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhập số nguyên: ");
                    String intInput = sc.nextLine();
                    try {
                        Integer result = validator.validateInteger(intInput);
                        System.out.println("Kết quả: " + result);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Không phải số nguyên hợp lệ");
                    }
                    break;

                case 2:
                    System.out.print("Nhập số thực float: ");
                    String floatInput = sc.nextLine();
                    try {
                        Float result = validator.validateFloat(floatInput);
                        System.out.println("Kết quả: " + result);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Không phải số thực float hợp lệ");
                    }
                    break;

                case 3:
                    System.out.print("Nhập số thực double: ");
                    String doubleInput = sc.nextLine();
                    try {
                        Double result = validator.validateDouble(doubleInput);
                        System.out.println("Kết quả: " + result);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Không phải số thực double hợp lệ");
                    }
                    break;

                case 4:
                    System.out.print("Nhập true hoặc false: ");
                    String boolInput = sc.nextLine();
                    try {
                        Boolean result = validator.validateBoolean(boolInput);
                        System.out.println("Kết quả: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Nhập chuỗi: ");
                    String stringInput = sc.nextLine();
                    try {
                        System.out.print("Nhập độ dài tối thiểu: ");
                        int min = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập độ dài tối đa: ");
                        int max = Integer.parseInt(sc.nextLine());
                        String result = validator.validateString(stringInput, min, max);
                        System.out.println("Kết quả: " + result);
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi: Độ dài min/max phải là số");
                    }catch (IllegalArgumentException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Nhập email: ");
                    String emailInput = sc.nextLine();
                    try {
                        String result = validator.validateEmail(emailInput);
                        System.out.println("Kết quả: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.print("Nhập số điện thoại: ");
                    String phoneInput = sc.nextLine();
                    try {
                        String result = validator.validatePhone(phoneInput);
                        System.out.println("Kết quả: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);

        sc.close();
    }
}