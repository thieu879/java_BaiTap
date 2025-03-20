import java.util.ArrayList;

public class Bt2 {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(6);
        numberList.add(7);
        numberList.add(8);
        numberList.add(9);
        numberList.add(10);
        System.out.println("Danh sách ban đầu: " +  numberList);
        for (int i = 0; i < numberList.size(); i++) {
            if(numberList.get(i) % 3 == 0) {
                numberList.remove(i);
            }
        }
        System.out.println("danh sách sau khi xoá: " +  numberList);
    }
}
