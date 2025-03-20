import java.util.ArrayList;

public class Bt8 {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("kiwi");
        stringList.add("grape");
        stringList.add("strawberry");

        System.out.println("Danh sách ban đầu: " + stringList);

        for (int i = 0; i < stringList.size() - 1; i++) {
            for (int j = i + 1; j < stringList.size(); j++) {
                if (shouldSwap(stringList.get(i), stringList.get(j))) {
                    String temp = stringList.get(i);
                    stringList.set(i, stringList.get(j));
                    stringList.set(j, temp);
                }
            }
        }

        System.out.println("Danh sách sau khi sắp xếp: " + stringList);
    }

    private static boolean shouldSwap(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return true;
        } else if (s1.length() == s2.length() && s1.compareTo(s2) > 0) {
            return true;
        }
        return false;
    }
}
