import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bt1 {
    public static void main(String[] args) {
        List<String> strings = List.of("lambda", "stream", "Java", "functional");

        List<String> filteredStrings = filterNonEmptyStrings(strings);
        filteredStrings.forEach(System.out::println);
    }

    public static List<String> filterNonEmptyStrings(List<String> strings) {
        Predicate<String> isNotEmpty = s -> s != null && !s.trim().isEmpty();
        return strings.stream()
                .filter(isNotEmpty)
                .collect(Collectors.toList());
    }
}
