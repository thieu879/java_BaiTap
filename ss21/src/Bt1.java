import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập số nguyên thứ nhất: ");
            int n1 =sc.nextInt();
            System.out.println("Nhập số nguyên thứ hai: ");
            int n2 =sc.nextInt();
            double result = n1 / n2;
            System.out.println("Kết quả: " + result);
        }catch (ArithmeticException e){
            System.err.println("không thể chia cho 0 ngoài 0");
        }catch (NumberFormatException e){
            System.err.println("Không dung kiểu dữ liệu là số");
        }catch (Exception e){
            System.out.println("Nhập lại đi");
        }finally {
            System.out.println("kết thúc khối lệnh");
        }
    }
}
