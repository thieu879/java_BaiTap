package business.model.employee;


import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

public class Employee {
    private String employeeId;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private int gradeSalary;
    private float salary;
    private LocalDate birthday;
    private String address;
    private String status;
    private int departmentId;

    // Constructor mặc định
    public Employee() {
    }

    // Constructor đầy đủ
    public Employee(String employeeId, String name, String email, String phone, String gender,
                    int gradeSalary, float salary, LocalDate birthday, String address,
                    String status, int departmentId) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.gradeSalary = gradeSalary;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
        this.status = status;
        this.departmentId = departmentId;
    }

    // Getter và Setter
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGradeSalary() {
        return gradeSalary;
    }

    public void setGradeSalary(int gradeSalary) {
        this.gradeSalary = gradeSalary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void validate() {
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã nhân viên không được để trống.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên nhân viên không được để trống.");
        }
        if (email == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            throw new IllegalArgumentException("Email không hợp lệ.");
        }
        if (phone == null || !Pattern.matches("\\d{10,11}", phone)) {
            throw new IllegalArgumentException("Số điện thoại phải có 10-11 chữ số.");
        }
        if (gender == null || (!gender.equals(Gender.MALE.getValue()) && !gender.equals(Gender.FEMALE.getValue()))) {
            throw new IllegalArgumentException("Giới tính phải là 'Nam' hoặc 'Nữ'.");
        }
        if (gradeSalary < 1 || gradeSalary > 10) {
            throw new IllegalArgumentException("Bậc lương phải từ 1 đến 10.");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Lương phải lớn hơn 0.");
        }
        if (birthday == null || birthday.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("Nhân viên phải từ 18 tuổi trở lên.");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Địa chỉ không được để trống.");
        }
        if (status == null || (!status.equals(EmployeeStatus.ACTIVE.getValue()) && !status.equals(EmployeeStatus.INACTIVE.getValue()))) {
            throw new IllegalArgumentException("Trạng thái nhân viên phải là 'hoạt động' hoặc 'ngừng hoạt động'.");
        }
        if (departmentId <= 0) {
            throw new IllegalArgumentException("Mã phòng ban phải lớn hơn 0.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", gradeSalary=" + gradeSalary +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}