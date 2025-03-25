package Bt7;

import java.util.List;
import java.util.function.Predicate;

public class ListProcessorImpl implements ListProcessor {

    @Override
    public boolean containsNegative(List<Integer> list) {
        Predicate<Integer> predicate = x -> x < 0;
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                return true;
            }
        }
        return false;
    }
}
