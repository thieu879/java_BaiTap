package presentation;

import business.*;
import java.util.Scanner;

public class UniversityManager {
    private static CourseBusiness courseBusiness = new CourseBusiness();
    private static TeacherBusiness teacherBusiness = new TeacherBusiness();
    private static StudentBusiness studentBusiness = new StudentBusiness();
    private static CourseRegistrationBusiness crBusiness = new CourseRegistrationBusiness();
    private static ClassRoomBusiness classRoomBusiness = new ClassRoomBusiness();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayUniversityMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> courseMenu(scanner);
                case 2 -> teacherMenu(scanner);
                case 3 -> studentMenu(scanner);
                case 4 -> courseRegistrationMenu(scanner);
                case 5 -> classRoomMenu(scanner);
                case 6 -> dashboardMenu(scanner);
                case 7 -> {
                    System.out.println("Tạm biệt!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void displayUniversityMenu() {
        System.out.println("************************* UNIVERSITY MENU **********************");
        System.out.println("1. Quản lý khóa học");
        System.out.println("2. Quản lý giảng viên");
        System.out.println("3. Quản lý sinh viên");
        System.out.println("4. Đăng ký khóa học");
        System.out.println("5. Quản lý lớp học");
        System.out.println("6. Thống kê");
        System.out.println("7. Thoát");
        System.out.print("Chọn một tùy chọn: ");
    }

    private static void courseMenu(Scanner scanner) {
        while (true) {
            System.out.println("************************* COURSE MENU *************************");
            System.out.println("1. Danh sách khóa học sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới khóa học");
            System.out.println("3. Cập nhật khóa học");
            System.out.println("4. Xóa khóa học theo ID");
            System.out.println("5. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> courseBusiness.displayCourses();
                case 2 -> courseBusiness.addCourse(scanner);
                case 3 -> courseBusiness.updateCourse(scanner);
                case 4 -> {
                    System.out.print("Nhập mã khóa học để xóa: ");
                    String courseId = scanner.nextLine();
                    courseBusiness.deleteCourse(courseId, classRoomBusiness);
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void teacherMenu(Scanner scanner) {
        while (true) {
            System.out.println("************************* TEACHER MENU *************************");
            System.out.println("1. Danh sách giảng viên sắp xếp theo mã giảm dần");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Cập nhật giảng viên");
            System.out.println("4. Xóa giảng viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> teacherBusiness.displayTeachers();
                case 2 -> teacherBusiness.addTeacher(scanner);
                case 3 -> teacherBusiness.updateTeacher(scanner);
                case 4 -> {
                    System.out.print("Nhập mã giảng viên để xóa: ");
                    int teacherId = Integer.parseInt(scanner.nextLine());
                    teacherBusiness.deleteTeacher(teacherId, classRoomBusiness);
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void studentMenu(Scanner scanner) {
        while (true) {
            System.out.println("************************* STUDENT MENU *************************");
            System.out.println("1. Danh sách sinh viên được sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> studentBusiness.displayStudents();
                case 2 -> studentBusiness.addStudent(scanner);
                case 3 -> studentBusiness.updateStudent(scanner);
                case 4 -> {
                    System.out.print("Nhập mã sinh viên để xóa: ");
                    String studentId = scanner.nextLine();
                    studentBusiness.deleteStudent(studentId, crBusiness);
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void courseRegistrationMenu(Scanner scanner) {
        while (true) {
            System.out.println("******************* COURSE REGISTRATION MENU *****************");
            System.out.println("1. Đăng ký khóa học cho sinh viên");
            System.out.println("2. Hủy đăng ký học cho sinh viên");
            System.out.println("3. Duyệt đăng ký học sinh viên");
            System.out.println("4. Xem danh sách sinh viên đăng ký từng khóa học");
            System.out.println("5. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> crBusiness.registerCourse(scanner, studentBusiness, courseBusiness);
                case 2 -> {
                    System.out.print("Nhập mã sinh viên: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Nhập mã khóa học: ");
                    String courseId = scanner.nextLine();
                    crBusiness.cancelRegistration(studentId, courseId);
                }
                case 3 -> {
                    System.out.print("Nhập mã sinh viên: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Nhập mã khóa học: ");
                    String courseId = scanner.nextLine();
                    crBusiness.approveRegistration(studentId, courseId);
                }
                case 4 -> {
                    System.out.print("Nhập mã khóa học: ");
                    String courseId = scanner.nextLine();
                    crBusiness.displayRegistrationsByCourse(courseId);
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void classRoomMenu(Scanner scanner) {
        while (true) {
            System.out.println("********************** CLASS ROOM MENU **********************");
            System.out.println("1. Danh sách lớp học sắp xếp theo ngày tạo giảm dần");
            System.out.println("2. Thêm mới lớp học");
            System.out.println("3. Cập nhật thông tin lớp học");
            System.out.println("4. Xóa lớp học");
            System.out.println("5. Phân công giảng viên cho lớp");
            System.out.println("6. Thêm sinh viên vào cho lớp");
            System.out.println("7. Tạo lịch học cho lớp");
            System.out.println("8. Cập nhật trạng thái lớp");
            System.out.println("9. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> classRoomBusiness.displayClassRooms();
                case 2 -> classRoomBusiness.addClassRoom(scanner, courseBusiness, teacherBusiness);
                case 3 -> {
                    System.out.print("Nhập mã lớp học để cập nhật: ");
                    int classroomId = Integer.parseInt(scanner.nextLine());
                    classRoomBusiness.updateClassRoom(scanner, classroomId);
                }
                case 4 -> {
                    System.out.print("Nhập mã lớp học để xóa: ");
                    int classroomId = Integer.parseInt(scanner.nextLine());
                    classRoomBusiness.deleteClassRoom(classroomId);
                }
                case 5 -> {
                    System.out.print("Nhập mã lớp học: ");
                    int classroomId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập mã giảng viên: ");
                    int teacherId = Integer.parseInt(scanner.nextLine());
                    classRoomBusiness.assignTeacher(classroomId, teacherId, teacherBusiness);
                }
                case 6 -> {
                    System.out.print("Nhập mã lớp học: ");
                    int classroomId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập mã sinh viên: ");
                    String studentId = scanner.nextLine();
                    classRoomBusiness.addStudentToClass(classroomId, studentId, studentBusiness);
                }
                case 7 -> System.out.println("Chưa triển khai tạo lịch học!");
                case 8 -> System.out.println("Chưa triển khai cập nhật trạng thái lớp!");
                case 9 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void dashboardMenu(Scanner scanner) {
        while (true) {
            System.out.println("************************** DASHBOARD ***********************");
            System.out.println("1. Thống kê số sinh viên, giảng viên, khóa học, lớp học");
            System.out.println("2. Top 3 khóa học có nhiều sinh viên nhất");
            System.out.println("3. Top 3 lớp học có nhiều sinh viên nhất");
            System.out.println("4. Top 3 giảng viên dạy nhiều sinh viên nhất");
            System.out.println("5. Top 3 sinh viên đăng ký học nhiều nhất");
            System.out.println("6. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> System.out.println("Chưa triển khai thống kê!");
                case 2 -> System.out.println("Chưa triển khai top 3 khóa học!");
                case 3 -> System.out.println("Chưa triển khai top 3 lớp học!");
                case 4 -> System.out.println("Chưa triển khai top 3 giảng viên!");
                case 5 -> System.out.println("Chưa triển khai top 3 sinh viên!");
                case 6 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}