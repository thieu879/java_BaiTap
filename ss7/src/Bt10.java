import java.util.Scanner;

public class Bt10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi ban đầu: ");
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Đảo ngược chuỗi");
            System.out.println("2. Chèn chuỗi vào vị trí bất kỳ");
            System.out.println("3. Xóa một đoạn trong chuỗi");
            System.out.println("4. Thay thế một đoạn trong chuỗi");
            System.out.println("5. Chuyển đổi toàn bộ chuỗi thành chữ hoa/chữ thường");
            System.out.println("6. Thoát chương trình");
            System.out.print("Chọn chức năng (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    sb.reverse();
                    System.out.println("Chuỗi sau khi đảo ngược: " + sb);
                    break;
                case 2:
                    System.out.print("Nhập chuỗi con cần chèn: ");
                    String insertStr = scanner.nextLine();
                    System.out.print("Nhập vị trí cần chèn: ");
                    int insertPos = scanner.nextInt();
                    scanner.nextLine();
                    if (insertPos >= 0 && insertPos <= sb.length()) {
                        sb.insert(insertPos, insertStr);
                        System.out.println("Chuỗi sau khi chèn: " + sb);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;
                case 3:
                    System.out.print("Nhập vị trí bắt đầu: ");
                    int startDelete = scanner.nextInt();
                    System.out.print("Nhập vị trí kết thúc: ");
                    int endDelete = scanner.nextInt();
                    scanner.nextLine();
                    if (startDelete >= 0 && endDelete <= sb.length() && startDelete < endDelete) {
                        sb.delete(startDelete, endDelete);
                        System.out.println("Chuỗi sau khi xóa: " + sb);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập vị trí bắt đầu: ");
                    int startReplace = scanner.nextInt();
                    System.out.print("Nhập vị trí kết thúc: ");
                    int endReplace = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập chuỗi thay thế: ");
                    String replaceStr = scanner.nextLine();
                    if (startReplace >= 0 && endReplace <= sb.length() && startReplace < endReplace) {
                        sb.replace(startReplace, endReplace, replaceStr);
                        System.out.println("Chuỗi sau khi thay thế: " + sb);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 5:
                    System.out.print("Chọn 1 để chuyển thành chữ HOA, 2 để chuyển thành chữ thường: ");
                    int caseChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (caseChoice == 1) {
                        sb = new StringBuilder(sb.toString().toUpperCase());
                        System.out.println("Chuỗi sau khi chuyển thành chữ HOA: " + sb);
                    } else if (caseChoice == 2) {
                        sb = new StringBuilder(sb.toString().toLowerCase());
                        System.out.println("Chuỗi sau khi chuyển thành chữ thường: " + sb);
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;
                case 6:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 6.");
            }
        }
    }
}
