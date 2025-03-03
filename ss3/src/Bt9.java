import java.util.Scanner;

public class Bt9 {
    public static void main(String[] args) {
        System.out.print("Nhập số (100-999): ");
        int number = new Scanner(System.in).nextInt();
        if (number < 100 || number > 999) {
            System.out.println("Số nhập vào không hợp lệ");
            return;
        }
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = number % 10;
        System.out.print("Kết quả: ");
        printHundreds(hundreds);
        printTensAndUnits(tens, units);
    }
    private static void printHundreds(int hundreds) {
        switch (hundreds) {
            case 1 -> System.out.print("Một trăm ");
            case 2 -> System.out.print("Hai trăm ");
            case 3 -> System.out.print("Ba trăm ");
            case 4 -> System.out.print("Bốn trăm ");
            case 5 -> System.out.print("Năm trăm ");
            case 6 -> System.out.print("Sáu trăm ");
            case 7 -> System.out.print("Bảy trăm ");
            case 8 -> System.out.print("Tám trăm ");
            case 9 -> System.out.print("Chín trăm ");
        }
    }
    private static void printTensAndUnits(int tens, int units) {
        switch (tens) {
            case 0 -> {
                if (units != 0) System.out.print("lẻ ");
            }
            case 1 -> {
                switch (units) {
                    case 0 -> System.out.print("mười");
                    case 1 -> System.out.print("mười một");
                    case 2 -> System.out.print("mười hai");
                    case 3 -> System.out.print("mười ba");
                    case 4 -> System.out.print("mười bốn");
                    case 5 -> System.out.print("mười lăm");
                    case 6 -> System.out.print("mười sáu");
                    case 7 -> System.out.print("mười bảy");
                    case 8 -> System.out.print("mười tám");
                    case 9 -> System.out.print("mười chín");
                }
                return;
            }
            case 2 -> System.out.print("hai mươi ");
            case 3 -> System.out.print("ba mươi ");
            case 4 -> System.out.print("bốn mươi ");
            case 5 -> System.out.print("năm mươi ");
            case 6 -> System.out.print("sáu mươi ");
            case 7 -> System.out.print("bảy mươi ");
            case 8 -> System.out.print("tám mươi ");
            case 9 -> System.out.print("chín mươi ");
        }
        switch (units) {
            case 1 -> System.out.print("một");
            case 2 -> System.out.print("hai");
            case 3 -> System.out.print("ba");
            case 4 -> System.out.print("bốn");
            case 5 -> System.out.print("năm");
            case 6 -> System.out.print("sáu");
            case 7 -> System.out.print("bảy");
            case 8 -> System.out.print("tám");
            case 9 -> System.out.print("chín");
        }
    }
}
