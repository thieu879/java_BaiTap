import java.util.Scanner;

public class Bt6 {
    public static void main(String[] args) {
        System.out.print("Nhập Tên học sinh: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Nhập điểm môn 1: ");
        float n1 = new Scanner(System.in).nextFloat();
        System.out.print("Nhập điểm môn 2: ");
        float n2 = new Scanner(System.in).nextFloat();
        System.out.print("Nhập điểm môn 3: ");
        float n3 = new Scanner(System.in).nextFloat();
        float avg = (n1 + n2 + n3) / 3;
        if (avg>=8.0 && avg<=10.0) {
            System.out.println("Tên: " +name+" Điểm trung bình: "+avg+" xếp loại: giỏi");
        } else if (avg>=6.5 && avg<8.0) {
            System.out.println("Tên: " +name+" Điểm trung bình: "+avg+" xếp loại: Khá");
        } else if (avg>=5.0 && avg<6.6) {
            System.out.println("Tên: " +name+" Điểm trung bình: "+avg+" xếp loại: Trung Bình");
        } else if (avg>=0.0 && avg<5.0) {
            System.out.println("Tên: " +name+" Điểm trung bình: "+avg+" xếp loại: Yếu");
        }else {
            System.err.println("Lỗi");
        }
        
        String rank =   (avg >= 8.0 && avg <= 10.0) ? "Giỏi" :
                        (avg >= 6.5 && avg < 8.0) ? "Khá" :
                        (avg >= 5.0 && avg < 6.5) ? "Trung Bình" :
                        (avg >= 0.0 && avg < 5.0) ? "Yếu" : "Lỗi";

        System.out.println("Tên: " + name + " Điểm trung bình: " + avg + " Xếp loại: " + rank);
    }
}
