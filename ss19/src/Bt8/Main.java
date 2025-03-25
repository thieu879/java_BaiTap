package Bt8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listOdd = new ArrayList<Integer>();
        listOdd.add(1);
        listOdd.add(2);
        listOdd.add(3);
        listOdd.add(4);
        listOdd.add(5);
        listOdd.add(6);
        ListProcessorImpl listProcessor = new ListProcessorImpl();
        ListProcessor.printList(listOdd);
        System.out.println("Tổng các số lẻ: "+ listProcessor.sumOddNumbers(listOdd));
        if (!listProcessor.checkOdd(listOdd)) {
            System.out.println("Không có phần tử lẻ");
        }else {
            System.out.println("Các phần tử lẻ là: ");
        }
    }
}
