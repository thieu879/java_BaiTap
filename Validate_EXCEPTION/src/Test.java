import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validator validator = new Validator();
        do {
            System.out.println("Menu");
            System.out.println("1. Kiểm tra kiểu số nguyên\n");
            System.out.println("2. Kiểm tra kiểu số thực float\n");
            System.out.println("3. Kiểm tra kiểu số tự double\n");
            System.out.println("4. Validate kiểu Boolean với giá trị nhập vào là true/false ");
            System.out.println("5. Validate kiếu String, bắt buộc nhập (Không được empty, phải cắt bỏ khoảng trắng 2 đầu), có độ dài từ min đến max \n");
            System.out.println("6. Validate kiểu email, phải có định dạng emai \n");
            System.out.println("7. Validate kiểu phone, phải có định dạng số điện thoại di động Việt Nam\n");
            System.out.println("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập đi: ");
                    int n = sc.nextInt();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }while (true);
    }
}
