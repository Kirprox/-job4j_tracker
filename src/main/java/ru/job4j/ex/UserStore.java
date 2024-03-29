package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User returnUser = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                returnUser = user;
                break;
            }
        }
        if (returnUser == null) {
            throw new UserNotFoundException("Такого пользователя нет в списке");
        }
        return returnUser;
    }

    public static boolean validate(User user) throws UserInvalidException {

        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        return true;
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
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
