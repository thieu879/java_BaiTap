package Bt7;

import java.util.List;

public interface ListProcessor {
    public abstract boolean containsNegative(List<Integer> list);
    public static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
