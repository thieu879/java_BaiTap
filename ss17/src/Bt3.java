import java.util.HashSet;
import java.util.Iterator;

public class Bt3 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            hashSet.add(i);
        }
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if(next %2 ==0){
                iterator.remove();
            }
        }
        System.out.println(hashSet);
    }
}
