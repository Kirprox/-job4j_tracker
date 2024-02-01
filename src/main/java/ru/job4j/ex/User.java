package ru.job4j.ex;

public class User {
    private String username;
    private boolean valid2;

    public User(String username, boolean valid) {
        this.username = username;
        this.valid2 = valid;
    }

    public String getUsername() {
        return username;
    }

    public boolean isValid2() {
        return valid2;
    }
}
