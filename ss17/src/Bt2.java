import java.util.HashSet;
import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("C++");
        set.add("Python");
        set.add("JavaScript");
        System.out.println("Nhập tên muốn tìm kiếm: ");
        String search = new Scanner(System.in).next();
        if (set.contains(search)) {
            System.out.println("Có tồn tại trong hashset");
        } else {
            System.out.println("Không tồn tại trong hashset");
        }
    }
}
