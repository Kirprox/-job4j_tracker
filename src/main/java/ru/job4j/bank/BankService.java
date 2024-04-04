package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу пользователя со счетами
 * @author Kirill R
 * @version 1.0
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляет нового пользователя в систему
     * @param user пользователь, который будет добавлен тип User
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * метод удаляет пользователя из системы
     * принимает на вход пасспорт пользователя
     * @param passport паспорт, по которому пользователь удаляется из системы тип String
     */

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * метод добавляет новый счет клиенту
     * на вход принимает паспорт клиента и новый счет
     * @param passport паспорт по которому находится пользователь в системе тип String
     * @param account счет, который добавится. Тип Account
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> tmp = (users.get(user));
            if (!tmp.contains(account)) {
                tmp.add(account);
            }
        }
    }

    /**
     * метод ищет клиента по пасспорту
     * на вход принимает паспорт клиента
     * @param passport пасспорт клиента тип String
     * @return возвращает клиента,который был найден по пасспорту
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * метод ищет счет по реквизитам
     * принимает на вход пасспорт клиента и реквизит
     * @param passport пасспорт пользователя тип String
     * @param requisite реквизит пользователя тип String
     * @return возвращает счет, который был найден
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = (users.get(user));
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * метод переводит деньги с одного счета на другой
     * принимает на вход пасспорт и реквизит, с коротого будут списаны средства,
     * пасспорт и реквизит, на который поступят средства и количество денег
     * @param sourcePassport пасспорт пользователя тип String
     * @param sourceRequisite реквизит пользователя тип String
     * @param destinationPassport пасспорт пользователя тип String
     * @param destinationRequisite реквизит пользователя тип String
     * @param amount количество денег, переводимых со счета на другой счет тип double
     * @return возвращает true если перевод удался и false если перевод не удался
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount == null
                || destinationAccount == null
                || sourceAccount.getBalance() < amount) {
            return false;
        }
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        return true;
    }

    /**
     * метод получает список всех счетов пользователя
     * принимает на вход пользователя
     * @param user пользователь, по которому осуществляется поиск
     * @return возвращает список счетов пользователя тип List
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
