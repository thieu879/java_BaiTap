import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập số đi: ");
            int n = sc.nextInt();
            if(isPrime(n)){
                System.out.println("Là số nguyên tố");
            }else {
                System.out.println("không là số nguyên tố");
            }

        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Bye bye");
        }
    }
    public static boolean isPrime(int number){
        if (number<=0){
            throw new IllegalArgumentException("không hợp lệ để kiểm tra số nguyên tố");
        }
        if (number<2){
            return false;
        }else if (number==2 || number==3){
            return true;
        }
        for (int i=2;i<=Math.sqrt(number);i++){
            if (number%i==0){
                return false;
            }
        }
        return true;
    }
}
