import java.util.ArrayList;

public class Bt6 {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(2);
        numberList.add(4);
        numberList.add(1);
        numberList.add(5);
        for (int i = 0; i < numberList.size(); i++) {
            for (int j = i + 1; j < numberList.size(); j++) {
                if (numberList.get(i).equals(numberList.get(j))) {
                    numberList.remove(j);
                    j--;
                }
            }
        }
        System.out.println("Danh sách sau khi loại bỏ trùng lặp: " + numberList);
    }
}
