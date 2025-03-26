import java.util.List;
import java.util.Optional;

public class Bt5 {
    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList= List.of(10, 10, 10);

        Optional<Integer> secondLarrgest = normalList.stream().distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst();

        secondLarrgest.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Không tìm thấy")
        );
    }
}