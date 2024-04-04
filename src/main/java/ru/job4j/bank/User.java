package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает клиента
 * @author Kirill R
 * @version 1.0
 */

public class User {
    /**
     * поля паccпорт и имя пользователя
     */
    private String passport;
    private String username;

    /**
     * стандартный конструктор класса User
     * @param passport пасспорт клиента тип String
     * @param username имя клиента тип String
     */

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * метод геттер возвращает значение поля passport
     * @return возвращает пасспорт клиента тип String
     */

    public String getPassport() {
        return passport;
    }

    /**
     * метод сеттер задает значение поля passport по введенному параметру
     * @param passport пасспорт пользователя, который будет присвоен полю passport
     */

    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * метод геттер для поля userName
     * @return возвращает значение поля userName
     */

    public String getUsername() {
        return username;
    }

    /**
     * метод сеттер для поля userName
     * @param username имя пользователя, которое будет присвоено полю userName
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * переопределенный equals
     * идет сравнение только по пасспорту
     * @param o типа Object
     * @return результат сравнения тип boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * переопределенный hashCode
     * @return хеш код тип int
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
