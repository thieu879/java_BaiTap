package business.model.employee;

public enum EmployeeStatus {
    ACTIVE("hoạt động"),
    INACTIVE("ngừng hoạt động");

    private final String value;

    EmployeeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
