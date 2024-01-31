package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User returnUser = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                returnUser = user;
            }
        }
        if (returnUser == null) {
            throw new UserNotFoundException();
        }
        return returnUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result = user.isValid();
        if (!result || user.getUsername().length() < 3) {
            throw new UserInvalidException();
        }
        return result;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println("Пользователь не валидный");
        } catch (UserNotFoundException e) {
            System.out.println("Такого пользователя нет в списке");
        }
    }
}
