package business.service.student;

import business.dao.student.StudentDao;
import business.dao.student.StudentDaoIpm;
import business.model.Student;

import java.util.List;

public class StudentServiceIpm implements StudentService {
    private final StudentDao studentDao;

    public StudentServiceIpm() {
        studentDao = new StudentDaoIpm();
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public boolean delete(Student student) {
        return studentDao.delete(student);
    }

    @Override
    public int getCountStudentByStatus(boolean status) {
        return studentDao.getCountStudentByStatus(status);
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }
}
