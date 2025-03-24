import java.util.HashMap;
import java.util.Map;

public class Bt1 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Nguyễn Văn A", 1);
        hashMap.put("Nguyễn Văn B", 20);
        hashMap.put("Nguyễn Văn C", 31);
        hashMap.put("Nguyễn Văn D", 11);
        hashMap.put("Nguyễn Văn E", 21);
        String name = "Nguyễn Văn E";
        if (hashMap.containsKey(name)) {
            System.out.println(name);
        }else {
            System.out.println("Không tồn tại trong hashMap");
        }
    }
}
