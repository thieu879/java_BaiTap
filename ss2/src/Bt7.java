import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        System.out.print("Nhập giờ: ");
        int hour = new Scanner(System.in).nextInt();
        System.out.print("Nhập phút: ");
        int minute = new Scanner(System.in).nextInt();
        System.out.print("Nhập Giây: ");
        int second = new Scanner(System.in).nextInt();
        int totalSecond = hour*3600 + minute * 60 + second;
        System.out.println("Số Giây ban đầu là: "+ totalSecond);

        System.out.print("Nhập giờ thêm: ");
        int newhour = new Scanner(System.in).nextInt();
        System.out.print("Nhập phút thêm: ");
        int newminute = new Scanner(System.in).nextInt();
        System.out.print("Nhập Giây thêm: ");
        int newsecond = new Scanner(System.in).nextInt();
        int newtotalSecond = newhour*3600 + newminute * 60 + newsecond;
        int result =  totalSecond+newtotalSecond;
        System.out.println("Số Giây sau khi cộng là: " + result);

        int resulthour = result /  3600;
        int resultminute = (result % 3600)/60;
        int resultsecond = (result % 3600)%60;
        System.out.println("Số giờ sau khi cộng là: " + resulthour);
        System.out.println("Số phút sau khi cộng là: " + resultminute);
        System.out.println("Số Giây sau khi cộng là: " + resultsecond);
    }
}
