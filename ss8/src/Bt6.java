import java.util.Scanner;

public class Bt6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("===== MENU CHÍNH =====");
            System.out.println("1. Xử lý chuỗi");
            System.out.println("2. Xử lý số nguyên");
            System.out.println("3. Thoát chương trình");
            System.out.print("Chọn chức năng (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            if (choice == 1) {
                boolean subRunning = true;
                while (subRunning) {
                    System.out.println("===== MENU XỬ LÝ CHUỖI =====");
                    System.out.println("1. Nhập chuỗi");
                    System.out.println("2. Loại bỏ khoảng trắng thừa");
                    System.out.println("3. Đếm số lần xuất hiện của từng ký tự");
                    System.out.println("4. Chuyển đổi chuỗi thành dạng chuẩn");
                    System.out.println("5. Quay lại menu chính");
                    System.out.print("Chọn chức năng (1-5): ");

                    int stringChoice = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer

                    if (stringChoice == 1) {
                        System.out.print("Nhập chuỗi: ");
                        String str = scanner.nextLine();
                    }
                    else if (stringChoice == 2) {
                        System.out.print("Nhập chuỗi: ");
                        String str = scanner.nextLine();
                        String result = "";
                        for (int i = 0; i < str.length(); i++) {
                            if (!(i > 0 && str.charAt(i) == ' ' && str.charAt(i - 1) == ' ')) {
                                result += str.charAt(i);
                            }
                        }
                        System.out.println("Chuỗi sau khi loại bỏ khoảng trắng thừa: " + result);
                    }
                    else if (stringChoice == 3) {
                        System.out.print("Nhập chuỗi: ");
                        String str = scanner.nextLine();
                        int[] freq = new int[256];
                        for (int i = 0; i < str.length(); i++) {
                            freq[str.charAt(i)]++;
                        }
                        for (int i = 0; i < freq.length; i++) {
                            if (freq[i] > 0) {
                                System.out.println((char) i + ": " + freq[i]);
                            }
                        }
                    }
                    else if (stringChoice == 4) {
                        System.out.print("Nhập chuỗi: ");
                        String str = scanner.nextLine();
                        String result = "";
                        boolean capitalize = true;
                        for (int i = 0; i < str.length(); i++) {
                            if (capitalize && Character.isLetter(str.charAt(i))) {
                                result += Character.toUpperCase(str.charAt(i));
                                capitalize = false;
                            } else {
                                result += Character.toLowerCase(str.charAt(i));
                            }
                            if (str.charAt(i) == ' ') {
                                capitalize = true;
                            }
                        }
                        System.out.println("Chuỗi chuẩn hóa: " + result);
                    }
                    else if (stringChoice == 5) {
                        subRunning = false;
                    }
                }
            }
            else if (choice == 2) {
                boolean subRunning = true;
                while (subRunning) {
                    System.out.println("===== MENU XỬ LÝ MẢNG SỐ NGUYÊN =====");
                    System.out.println("1. Nhập mảng số nguyên");
                    System.out.println("2. Tìm số nguyên tố lớn nhất trong mảng");
                    System.out.println("3. Đếm số phần tử có chữ số đầu tiên là số lẻ");
                    System.out.println("4. Kiểm tra mảng có phải là mảng đối xứng không");
                    System.out.println("5. Quay lại menu chính");
                    System.out.print("Chọn chức năng (1-5): ");

                    int arrayChoice = scanner.nextInt();

                    if (arrayChoice == 1) {
                        System.out.print("Nhập số lượng phần tử: ");
                        int n = scanner.nextInt();
                        int[] arr = new int[n];
                        for (int i = 0; i < n; i++) {
                            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
                            arr[i] = scanner.nextInt();
                        }
                    }
                    else if (arrayChoice == 2) {
                        System.out.println("Chức năng chưa được triển khai.");
                    }
                    else if (arrayChoice == 3) {
                        System.out.println("Chức năng chưa được triển khai.");
                    }
                    else if (arrayChoice == 4) {
                        System.out.println("Chức năng chưa được triển khai.");
                    }
                    else if (arrayChoice == 5) {
                        subRunning = false;
                    }
                }
            }
            else if (choice == 3) {
                running = false;
            }
        }
    }
}
