import java.util.HashSet;
import java.util.TreeSet;

public class Bt6 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet1.add(10);
        hashSet1.add(20);
        hashSet1.add(30);
        hashSet1.add(40);
        hashSet2.add(30);
        hashSet2.add(40);
        hashSet2.add(50);
        hashSet2.add(60);
        hashSet1.retainAll(hashSet2);
        TreeSet<Integer> treeSet = new TreeSet<>(hashSet1);
        System.out.println(treeSet);
    }
}
