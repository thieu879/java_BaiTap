package business.model.user;

public enum UserStatus {
    ACTIVE("hoạt động"),
    INACTIVE("ngừng hoạt động");

    private final String value;

    UserStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
