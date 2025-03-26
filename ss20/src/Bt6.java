import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Bt6 {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> itemMap = items.stream().collect(Collectors.toMap(Function.identity(), item -> 1, Integer::sum));
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thời điểm xử lý: ").append(time.format(formatter)).append("\n");
        stringBuilder.append("{\n");

        String jsonContent = itemMap.entrySet().stream()
                .map(entry -> String.format(entry.getKey() + ": "+ entry.getValue()))
                .collect(Collectors.joining(",\n"));

        stringBuilder.append(jsonContent);
        stringBuilder.append("\n}");

        System.out.println(stringBuilder.toString());
    }
}
