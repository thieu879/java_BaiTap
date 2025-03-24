import java.util.Map;
import java.util.TreeMap;

public class Bt4 {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("NV123", 1000);
        map.put("NV111", 1000);
        map.put("NV112", 1000);
        map.put("NV113", 1000);
        map.put("NV124", 1000);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("\n");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getKey() == "NV123") {
                entry.setValue(entry.getValue()+1000);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("\n");
        map.remove("NV124",1000);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
