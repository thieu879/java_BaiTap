package Bt7;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(-3);
        list.add(4);
        list.add(5);
        list.add(6);
        ListProcessorImpl listProcessorImpl = new ListProcessorImpl();
        ListProcessor.printList(list);
        if (listProcessorImpl.containsNegative(list)) {
            System.out.println("Danh sách chứa số âm");
        }else {
            System.out.println("Danh sách không có số âm");
        }
    }
}
