import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bt1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", " ", "Stream", "", "Functional");

        Predicate<String>  isNotEmpty = s -> !s.isEmpty();

        List<String> filterStrings = strings.stream().filter(isNotEmpty).collect(Collectors.toList());

        System.out.println(filterStrings);
    }
}