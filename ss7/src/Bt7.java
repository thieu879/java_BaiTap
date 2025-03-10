import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        System.out.print("Nhập chuỗi theo định dạng PascalCase: ");
        String n = new Scanner(System.in).nextLine();

        StringBuilder sb = new StringBuilder();
        if (n.length() > 0){
            sb.append(Character.toLowerCase(n.charAt(0)));
            for (int i = 1; i < n.length(); i++) {
                char c = n.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append("_");
                    sb.append(Character.toLowerCase(c));
                }else {
                    sb.append(c);
                }
            }
        }else {
            System.out.println(" ");
        }
        System.out.println(sb.toString());
    }
}
