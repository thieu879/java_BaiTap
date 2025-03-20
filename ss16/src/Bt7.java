import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bt7 {
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
        ArrayList<Integer> uniqueElements = new ArrayList<>();
        ArrayList<String> duplicateElements = new ArrayList<>();
        for (int i = 0; i < uniqueNumbers.size(); i++) {
            if (countList.get(i) == 1) {
                uniqueElements.add(uniqueNumbers.get(i));
            }else {
                duplicateElements.add(uniqueNumbers.get(i) +  " - " + uniqueNumbers.get(i) + " lần");
            }
        }
        System.out.println("Số lần xuất hiện 1 lần của từng phần tử: " + uniqueElements);
        System.out.println("Số lần xuất hiện nhiều lần của từng phần tử: " + duplicateElements);
    }
}
