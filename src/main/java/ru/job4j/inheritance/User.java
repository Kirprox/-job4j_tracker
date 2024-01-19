package ru.job4j.inheritance;

public class User extends Base {
    public User() {
        System.out.println("user constr.");
    }

    public static void main(String[] args) {
        User user = new User();
    }
}
