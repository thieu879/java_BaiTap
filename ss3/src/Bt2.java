import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        System.out.print("Nhập số thứ nhất: ");
        int n1= new Scanner(System.in).nextInt();
        System.out.print("Nhập số thứ hai: ");
        int n2= new Scanner(System.in).nextInt();
        System.out.print("Nhập số thứ ba: ");
        int n3= new Scanner(System.in).nextInt();
        if (n1==n2 && n2==n3) {
            System.out.println("Ba số nguyên bằng nhau");
        }else if (n1!=n2 && n2!=n3 && n1!=n3) {
            int max;
            if(n1>n2){
                if(n1>n3){
                    max = n1;
                }else {
                    max = n3;
                }
            }else {
                if(n2>n3){
                    max = n2;
                }else  {
                    max = n3;
                }
            }
            System.out.println("số lớn nhất là: "+max);
        }
    }
}
