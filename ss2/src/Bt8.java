import java.util.Scanner;
public class Bt8 {
    public static void main(String[] args) {
        System.out.print("Nhập mã sinh viên: ");
        String studentId = new Scanner(System.in).nextLine();

        System.out.print("Nhập tên sinh viên: ");
        String name = new Scanner(System.in).nextLine();

        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = new Scanner(System.in).nextLine();

        System.out.print("Nhập ngày tháng năm sinh (dd/MM/yyyy): ");
        String birthDate = new Scanner(System.in).nextLine();

        System.out.print("Nhập giới tính (1: Nam, 0: Nữ): ");
        boolean isMale = new Scanner(System.in).nextInt() == 1;

        System.out.print("Nhập điểm Toán: ");
        float math = new Scanner(System.in).nextFloat();

        System.out.print("Nhập điểm Lý: ");
        float physics = new Scanner(System.in).nextFloat();

        System.out.print("Nhập điểm Hóa: ");
        float chemistry = new Scanner(System.in).nextFloat();

        System.out.print("Nhập điểm Sinh: ");
        float biology = new Scanner(System.in).nextFloat();

        System.out.print("Nhập điểm Ngoại ngữ: ");
        float foreignLanguage = new Scanner(System.in).nextFloat();

        float avg = (math + physics + chemistry + biology + foreignLanguage) / 5;

        System.out.println("\n--- Thông tin sinh viên ---");
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("Tên sinh viên: " + name);
        System.out.println("Số điện thoại: " + phoneNumber);
        System.out.println("Ngày sinh: " + birthDate);
        System.out.println("Giới tính: " + (isMale ? "Nam" : "Nữ"));
        System.out.println("Điểm Toán: " + math);
        System.out.println("Điểm Lý: " + physics);
        System.out.println("Điểm Hóa: " + chemistry);
        System.out.println("Điểm Sinh: " + biology);
        System.out.println("Điểm Ngoại ngữ: " + foreignLanguage);
        System.out.println("Điểm trung bình: " + avg);
    }
}
