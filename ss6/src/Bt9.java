import java.util.Scanner;

public class Bt9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập URL: ");
        String url = scanner.nextLine().trim();
        if (url.startsWith("http://") || url.startsWith("https://")) {
            int protocolEnd = url.indexOf("://");
            String protocol = url.substring(0, protocolEnd);
            String remainingUrl = url.substring(protocolEnd + 3);
            int pathStart = remainingUrl.indexOf("/");
            String domain;
            String path = "/";
            if (pathStart != -1) {
                domain = remainingUrl.substring(0, pathStart);
                path = remainingUrl.substring(pathStart);
            } else {
                domain = remainingUrl;
            }
            System.out.println("URL hợp lệ");
            System.out.println("Giao thức: " + protocol);
            System.out.println("Tên miền: " + domain);
            System.out.println("Đường dẫn: " + path);
        } else {
            System.out.println("URL không hợp lệ");
        }
    }
}
