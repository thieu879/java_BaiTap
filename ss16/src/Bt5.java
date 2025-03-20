import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bt5 {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(2);
        numberList.add(4);
        System.out.println("Mảng ban đầu: " + numberList);
        ArrayList<Integer> uniqueNumbers = new ArrayList<>();
        ArrayList<Integer> countList = new ArrayList<>();
        for (int num : numberList) {
            boolean found = false;
            for (int i = 0; i < uniqueNumbers.size(); i++) {
                if (uniqueNumbers.get(i) == num) {
                    countList.set(i, countList.get(i) + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                uniqueNumbers.add(num);
                countList.add(1);
            }
        }
        System.out.println("Số lần xuất hiện của từng phần tử:");
        for (int i = 0; i < uniqueNumbers.size(); i++) {
            System.out.println(uniqueNumbers.get(i) + " - " + countList.get(i) + " lần");
        }
    }
}
