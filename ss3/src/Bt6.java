import java.util.Scanner;

public class Bt6 {
    public static void main(String[] args) {
        System.out.print("Nhập một số nguyên từ 1 đến 12 (tương ứng với tháng)");
        int a = new Scanner(System.in).nextInt();
        switch (a){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("tháng "+a+" có 31 ngày");
                break;
            case 2:
                System.out.println("tháng "+a+" có 28 ngày hoặc 29 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("tháng "+a+" có 30 ngày");
                break;
            default:
                System.err.println("Tháng không hợp lệ.");
                break;
        }
    }
}
