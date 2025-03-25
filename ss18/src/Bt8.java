import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Bt8 {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        System.out.print("Nhập số N: ");
        int n = new Scanner(System.in).nextInt();
        if(n<0){
            System.out.println("Đùa nhau à!");
        }else if(n>3999){
            System.out.println("Chưa có đâu!");
        }
        StringBuilder roman = new StringBuilder();
        for(Map.Entry<Integer, String> key : map.entrySet()){
            int value = key.getKey();
            String symbol = key.getValue();
            while (n>=value){
                roman.append(symbol);
                n -= value;
            }
        }
        System.out.println(roman.toString());
    }
}
