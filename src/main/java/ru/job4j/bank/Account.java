package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковский счет
 * @author Kirill R
 * @version 1.0
 */
public class Account {
    /**
     * поля реквизиты и баланс
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор, содержит 2 параметра
     * @param requisite реквизит тип String
     * @param balance баланс тип double
     */

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * метод, используемый для получение реквизита
     * @return возвращает значение поля requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * метод сеттер для поля реквизит
     * @param requisite реквизит, который присваивается полю requisite.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * метод, испульзуемый для получения баланся
     * @return возвращает значение поля balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * метод сеттер для поля balance
     *
     * @param balance баланс, который присваивается полю balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * переопределенный equals
     * идет сравнение только по реквизиту
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * переопределенный hashCode
     * @return хеш код счета тип int
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
