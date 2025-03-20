import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bt3 {
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
        int max = Collections.max(numberList);
        int min = Collections.min(numberList);
        System.out.println("Số lớn nhất: " + max);
        System.out.println("Số nhỏ nhất: " + min);
    }
}
