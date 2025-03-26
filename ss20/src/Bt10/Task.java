package Bt10;

import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private User assignedTo;
    private LocalDate dueDate;
    private boolean completed;

    public Task(int id, String title, User assignedTo, LocalDate dueDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String toDisplayString() {
        return "ID: " + id + " | Tiêu đề: " + title + " | Giao cho: " + assignedTo.getName() +
                " | Hạn: " + dueDate + " | Hoàn thành: " + (completed ? "Có" : "Không");
    }
}
