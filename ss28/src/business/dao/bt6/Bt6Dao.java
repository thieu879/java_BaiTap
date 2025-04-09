package business.dao.bt6;

import business.dao.AppDao;

public interface Bt6Dao extends AppDao {
    void add_department_with_employees(String departmentName, String employeeName);
}
