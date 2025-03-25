package Bt8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListProcessorImpl implements ListProcessor {
    @Override
    public int sumOddNumbers(List<Integer> list) {
        Predicate<Integer> isOdd = x -> x % 2 != 0;
        int sum = 0;
        List<Integer> listOdd = new ArrayList<>();
        for(Integer i : list) {
            if(isOdd.test(i)) {
                sum += i;
                listOdd.add(i);
            }
        }
        System.out.println("Các số lẻ: " + listOdd);
        return sum;
    }
}
