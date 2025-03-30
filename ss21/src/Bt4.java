import java.util.Scanner;

public class Bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập số đi: ");
            int n = sc.nextInt();
            System.out.println("bạn đã nhập số: " + n);
        }catch (NumberFormatException e){
            System.out.println("Lỗi: Bạn phải nhập số nguyên!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
        }
    }
}
