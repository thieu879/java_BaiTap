import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bt2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> list1 = list.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
        int sum = 0;
        for(Integer x : list1){
            sum += x;
        }
        System.out.println(sum);
    }
}
