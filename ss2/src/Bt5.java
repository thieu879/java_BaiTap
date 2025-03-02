import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        System.out.print("Nhập Chiều dài: ");
        int length = new Scanner(System.in).nextInt();
        System.out.print("Nhập chiều rộng: ");
        int width = new Scanner(System.in).nextInt();
        System.out.println("Diện tích hình chữ nhật = " + length * width);
        System.out.println("Chu vi hình chữ nhật = " + (2 *(length + width)));
    }
}
