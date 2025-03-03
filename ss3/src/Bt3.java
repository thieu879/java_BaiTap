import java.util.Scanner;

public class Bt3 {
    public static void main(String[] args) {
        System.out.print("Nhập điểm trung bình: ");
        float avg = new Scanner(System.in).nextFloat();
        if (avg>=8.0 && avg<=10.0) {
            System.out.println("xếp loại: giỏi");
        } else if (avg>=6.5 && avg<8.0) {
            System.out.println("xếp loại: Khá");
        } else if (avg>=5.0 && avg<6.6) {
            System.out.println("xếp loại: Trung Bình");
        } else if (avg>=0.0 && avg<5.0) {
            System.out.println("xếp loại: Yếu");
        }else {
            System.err.println("Lỗi");
        }
    }
}
