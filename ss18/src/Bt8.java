import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bt8 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        System.out.print("Nhập số N: ");
        int n = new Scanner(System.in).nextInt();
        if(n<0){
            System.out.println("Đùa nhau à!");
        }else if(n>10){
            System.out.println("Chưa có đâu!");
        }
        for(Map.Entry<Integer, String> key : map.entrySet()){
            if(key.getKey() == n){
                System.out.println("Chuyển thành số la mã là: "+key.getValue());
            }
        }
    }
}
