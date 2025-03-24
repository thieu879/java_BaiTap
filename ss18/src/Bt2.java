import java.util.HashMap;
import java.util.Map;

public class Bt2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Laptop", 500);
        map.put("Tablet", 500);
        map.put("iPhone", 1000);
        map.put("iPod", 500);
        if(map.containsKey("Laptop")){
            System.out.println("có sản phẩm laptop trong hashMap");
        }else {
            System.out.println("Không có sản phẩm  laptop trong hashMap");
        }
        if(map.containsValue(1000)){
            for (Map.Entry<String, Integer> hashmap:map.entrySet()){
                if(hashmap.getValue()==1000){
                    System.out.println("sản phẩm có giá trị bằng 1000 trong hashMap: "+hashmap.getKey());
                }
            }
        }else {
            System.out.println("Không có sản phẩm có giá trị bằng 1000 trong hashMap");
        }
    }
}
