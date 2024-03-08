package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        if (!users.containsKey(findByPassport(passport))) {
            return;
        }
        List<Account> tmp = new ArrayList<>(users.get(findByPassport(passport)));
        if (!tmp.contains(account)) {
            tmp.add(account);
        }
        users.put(findByPassport(passport), tmp);
    }

    public User findByPassport(String passport) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        if (findByPassport(passport) == null) {
            return null;
        }
        List<Account> accounts = new ArrayList<>(users.get(findByPassport(passport)));
        for (Account account : accounts) {
            if (account.getRequisite().equals(requisite)) {
                result = account;
                break;
            }
        }
        return result;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        if (findByRequisite(sourcePassport, sourceRequisite) == null
                || findByRequisite(destinationPassport, destinationRequisite) == null
                || findByRequisite(sourcePassport, sourceRequisite).getBalance() < amount) {
            return false;
        }
        double sourceBalance = findByRequisite(sourcePassport, sourceRequisite).getBalance();
        double destinationBalance = findByRequisite(destinationPassport, destinationRequisite).getBalance();
        findByRequisite(sourcePassport, sourceRequisite).setBalance(sourceBalance - amount);
        findByRequisite(destinationPassport, destinationRequisite).setBalance(destinationBalance + amount);
        return true;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
