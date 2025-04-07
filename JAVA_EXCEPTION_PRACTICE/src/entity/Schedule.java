package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Schedule implements IApp{
    private int scheduleId;
    private int classroomId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private static int autoId = 1;

    public Schedule() {
        this.scheduleId = autoId++;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã lớp học: ");
        this.classroomId = Integer.parseInt(scanner.nextLine());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.print("Nhập thời gian bắt đầu (yyyy-MM-dd HH:mm:ss): ");
        this.startTime = LocalDateTime.parse(scanner.nextLine(), formatter);

        System.out.print("Nhập thời gian kết thúc (yyyy-MM-dd HH:mm:ss): ");
        this.endTime = LocalDateTime.parse(scanner.nextLine(), formatter);
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Lịch học{" +
                "Mã lịch=" + scheduleId +
                ", Mã lớp=" + classroomId +
                ", Bắt đầu=" + startTime.format(formatter) +
                ", Kết thúc=" + endTime.format(formatter) +
                '}';
    }
}
