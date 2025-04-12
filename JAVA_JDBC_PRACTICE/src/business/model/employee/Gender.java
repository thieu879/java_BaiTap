package business.model.employee;

public enum Gender {
    MALE("Nam"),
    FEMALE("Nữ");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
