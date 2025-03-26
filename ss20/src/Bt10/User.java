package Bt10;

import java.util.Optional;

public class User {
    private int id;
    private String name;
    private Optional<String> email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    public Optional<String> getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email=" + email.orElse("Không có email") + "}";
    }
}
