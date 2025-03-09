public class Bt6 {
    public static void main(String[] args) {
        int[] originalArray = {25, 300, 25, 500, 700, 300, 100, 25, 700, 800, 700, 300, 100, 25, 25, 500, 100, 800, 300, 25};
        int[] markingArray = new int[1001];
        for (int num : originalArray) {
            markingArray[num]++;
        }
        int maxCount = 0;
        for (int i = 1; i <= 1000; i++) {
            if (markingArray[i] > maxCount) {
                maxCount = markingArray[i];
            }
        }
        System.out.println("Các phần tử xuất hiện nhiều nhất trong mảng:");
        for (int i = 1; i <= 1000; i++) {
            if (markingArray[i] == maxCount) {
                System.out.println("Giá trị: " + i + " - Xuất hiện: " + maxCount + " lần");
            }
        }
    }
}
