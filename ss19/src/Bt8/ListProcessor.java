package Bt8;

import java.util.List;
import java.util.function.Predicate;

public interface ListProcessor {
    public abstract int sumOddNumbers(List<Integer> list);
    public static void printList(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
    default boolean checkOdd(List<Integer> list) {
        Predicate<Integer> predicate = integer -> integer % 2 != 0;
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                return true;
            }
        }
        return false;
    }
}
