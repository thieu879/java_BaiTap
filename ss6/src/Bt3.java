import java.util.Scanner;
public class Bt3 {
    public static void main(String[] args) {
        System.out.print("Nhập chuỗi văn bản: ");
        String text = new Scanner(System.in).nextLine();
        System.out.print("Nhập từ cần tìm: ");
        String word = new Scanner(System.in).nextLine();
        int index = text.indexOf(word);
        if (index != -1) {
            System.out.println("Từ '" + word + "' xuất hiện tại vị trí: " + index);
        } else {
            System.out.println("Từ '" + word + "' không có trong chuỗi.");
        }
    }
}
