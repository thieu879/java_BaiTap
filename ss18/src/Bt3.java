import java.util.LinkedHashMap;
import java.util.Map;

public class Bt3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Laptop", 500);
        map.put("Tablet", 500);
        map.put("iPhone", 1000);
        map.put("iPod", 500);
        map.put("iPad", 2000);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue()+"\n");
        }
        if (map.containsKey("Laptop")) {
            map.put("Laptop", 200);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue()+"\n");
        }
        if (map.containsKey("Tablet")) {
            map.remove("Tablet",500);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
