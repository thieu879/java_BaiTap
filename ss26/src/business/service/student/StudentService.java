package business.service.student;

import business.model.Student;
import business.service.AppService;

public interface StudentService extends AppService<Student> {
    int getCountStudentByStatus(boolean status);
    Student findById(int id);
}
