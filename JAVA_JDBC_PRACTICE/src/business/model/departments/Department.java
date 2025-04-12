package business.model.departments;

import java.util.Objects;

public class Department {
    private int departmentId;
    private String name;
    private String description;
    private String status;

    // Constructor mặc định
    public Department() {
    }

    // Constructor đầy đủ
    public Department(int departmentId, String name, String description, String status) {
        this.departmentId = departmentId;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    // Getter và Setter
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void validate() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên phòng ban không được để trống.");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Mô tả phòng ban không được để trống.");
        }
        if (status == null || (!status.equals("hoạt động") && !status.equals("ngừng hoạt động"))) {
            throw new IllegalArgumentException("Trạng thái phòng ban phải là 'hoạt động' hoặc 'ngừng hoạt động'.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentId == that.departmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}