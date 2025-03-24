import java.util.*;

public class Bt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập N phần tử: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            System.out.print("Nhập đi: ");
            arr[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> shortList = new ArrayList<>(map.entrySet());
        shortList.sort((a,b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> entry : shortList) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
