import java.util.*;

public class Bt8 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 3, 2, 8, 4, 6};
        int k = 10;
        Set<String> pairSet = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    // Sắp xếp cặp số nhỏ trước, lớn sau
                    int first = Math.min(arr[i], arr[j]);
                    int second = Math.max(arr[i], arr[j]);
                    pairSet.add(first + "," + second);
                }
            }
        }
        List<String> pairList = new ArrayList<>(pairSet);
        Collections.sort(pairList);
        System.out.println("Các cặp số có tổng bằng " + k + ":");
        for (String pair : pairList) {
            System.out.println("(" + pair + ")");
        }
    }
}