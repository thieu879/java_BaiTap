package business.dao.student;

import business.dao.AppDao;
import business.model.Student;

public interface StudentDao extends AppDao<Student> {
    int getCountStudentByStatus(boolean status);
    Student findById(int id);
}
