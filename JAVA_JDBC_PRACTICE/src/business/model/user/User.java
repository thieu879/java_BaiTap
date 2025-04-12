package business.model.user;


import java.util.Objects;

public class User {
    private String username;
    private String password;
    private String status;

    // Constructor mặc định
    public User() {
    }

    // Constructor đầy đủ
    public User(String username, String password, String status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    // Getter và Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void validate() {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên đăng nhập không được để trống.");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Mật khẩu không được để trống.");
        }
        if (status == null || (!status.equals(UserStatus.ACTIVE.getValue()) && !status.equals(UserStatus.INACTIVE.getValue()))) {
            throw new IllegalArgumentException("Trạng thái người dùng phải là 'hoạt động' hoặc 'ngừng hoạt động'.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
