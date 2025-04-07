package validate;

import entity.Student;

import java.util.List;

public class ValidateStudent {
    public static boolean isValidStudentId(String studentId, List<Student> students) {
        if (studentId == null || !studentId.matches("^SV[A-Za-z0-9]{3}$")) {
            return false;
        }
        return students.stream().noneMatch(s -> s.getStudentId().equals(studentId));
    }

    public static boolean isValidGpa(double gpa) {
        return gpa >= 0 && gpa <= 10;
    }
}
