package Bt10;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1, "Quý", "quy@example.com");
        User u2 = new User(2, "Lan", null);
        User u3 = new User(3, "Huyền", "huyen@example.com");
        List<Task> tasks = List.of(
                new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
                new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
                new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
                new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
                new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true)
        );
        LocalDate currentDate = LocalDate.of(2025, 3, 23);
        System.out.println("== Danh sách công việc quá hạn và chưa hoàn thành ==");
        tasks.stream()
                .filter(task -> !task.isCompleted())
                .filter(task -> task.getDueDate().isBefore(currentDate))
                .forEach(task -> System.out.println(task.toDisplayString()));

        long completedTasks = tasks.stream()
                .filter(Task::isCompleted)
                .count();
        System.out.println("\n== Thống kê số công việc đã hoàn thành ==");
        System.out.println("Tổng số công việc đã hoàn thành: " + completedTasks);
        System.out.println("\n== Thống kê công việc theo người dùng ==");
        Map<User, Long> totalTasksByUser = tasks.stream()
                .collect(Collectors.groupingBy(Task::getAssignedTo, Collectors.counting()));

        Map<User, Long> overdueTasksByUser = tasks.stream()
                .filter(task -> !task.isCompleted())
                .filter(task -> task.getDueDate().isBefore(currentDate))
                .collect(Collectors.groupingBy(Task::getAssignedTo, Collectors.counting()));

        List<User> users = List.of(u1, u2, u3);
        users.forEach(user -> {
            long totalTasks = totalTasksByUser.getOrDefault(user, 0L);
            long overdueTasks = overdueTasksByUser.getOrDefault(user, 0L);
            System.out.println("Tên: " + user.getName());
            System.out.println("Email: " + user.getEmail().orElse("Không có email"));
            System.out.println("Tổng số công việc: " + totalTasks);
            System.out.println("Số công việc quá hạn: " + overdueTasks);
            System.out.println("-------------------");
        });
    }
}
