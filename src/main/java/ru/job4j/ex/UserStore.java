package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)){
                return user;
            }
        }
        throw new UserNotFoundException("User Not Found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User not valid");
        }
        return  true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Pe", true)
        };
        try {
            User user = null;
            user = findUser(users, "Pe");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch ( UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

    }
}
