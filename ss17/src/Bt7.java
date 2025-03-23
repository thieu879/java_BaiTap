import java.util.*;
import java.util.stream.Collectors;

public class Bt7 {
    public static void main(String[] args) {
        System.out.println("Nhập đi mà: ");
        String text = new Scanner(System.in).nextLine();
        String[] words = text.toLowerCase().split("\\W+");
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> sortedWords = new ArrayList<>(wordSet);
        Collections.sort(sortedWords);
        for (String word : wordSet) {
            int count = 0;
            for (String w : words) {
                if(word.equals(w)) {
                    count++;
                }
            }
            System.out.println(word + " : " + count);
        }
    }
}
