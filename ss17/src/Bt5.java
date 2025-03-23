import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Bt5 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet1.add(1);
        hashSet1.add(2);
        hashSet1.add(3);
        hashSet1.add(4);
        hashSet1.add(5);
        hashSet2.add(4);
        hashSet2.add(5);
        hashSet2.add(6);
        hashSet2.add(7);
        hashSet2.add(8);
        hashSet1.addAll(hashSet2);
        TreeSet<Integer> treeSet = new TreeSet<>(hashSet1);
        System.out.println(hashSet1);
        System.out.println(treeSet);
    }
}
