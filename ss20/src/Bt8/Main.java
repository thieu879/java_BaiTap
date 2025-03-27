package Bt8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Quý", "IT", 8.5),
                new Student("Lan", "Business", 7.2),
                new Student("Minh", "IT", 9.0),
                new Student("Huyền", "Design", 6.8),
                new Student("Long", "IT", 7.9),
                new Student("Trang", "Business", 8.1),
                new Student("Việt", "IT", 8.0),
                new Student("Tú", "Design", 7.5),
                new Student("Phúc", "Business", 6.9),
                new Student("An", "AI", 9.5)
        );
        Map<String, Long> majorStats = new HashMap<>();
        for (Student student : students) {
            String major = student.getMajor();
            majorStats.put(major, majorStats.getOrDefault(major, 0L) + 1);
        }
        System.out.println("Thống kê số lượng sinh viên theo chuyên ngành:");
        majorStats.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.println(
                                "Chuyên ngành: " + entry.getKey() +
                                        " ".repeat(10 - entry.getKey().length()) +
                                        "| Số lượng: " + entry.getValue()
                        )
                );
    }
}
