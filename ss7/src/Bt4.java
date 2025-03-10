import java.util.Scanner;

public class Bt4 {
    public static void main(String[] args) {
        System.out.print("Nhập chuỗi đi: ");
        String n = new Scanner(System.in).nextLine();
        String oldN = n.toLowerCase();
        String newN = new StringBuilder(oldN).reverse().toString();
        if(oldN.equals(newN)){
            System.out.println("Chuỗi đối xứng");
        }else {
            System.out.println("Chuỗi không đối xứng");
        }
    }
}
