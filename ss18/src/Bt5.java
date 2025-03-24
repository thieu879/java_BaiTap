import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Bt5 {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("Laptop", 400);
        map.put("Tablet", 500);
        map.put("iPhone", 1000);
        map.put("iPod", 500);
        map.put("iPad", 2000);
        Map<String, Integer> map2 = new TreeMap<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 500 && entry.getValue() <= 1500) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        for(Map.Entry<String, Integer> entry : map2.entrySet()) {
            System.out.println("Tên: "+entry.getKey() + ", giá: " + entry.getValue());
        }
    }
}
