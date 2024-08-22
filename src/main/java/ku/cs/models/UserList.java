package ku.cs.models;

import java.util.ArrayList;
import java.util.Objects;

public class UserList {
    private ArrayList<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.isUsername(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(String username, String password) {
        User exist = findUserByUsername(username);
        if (exist == null) {
            users.add(new User(username, password));
        }
    }


    //TODO: implements this method to change user's password to newPassword by verified oldPassword
    //TODO: return true if process is completed, otherwise return false
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        User exist = findUserByUsername(username);
        if (!newPassword.trim().isEmpty()) {
            if (exist.validatePassword(oldPassword)) {
                exist.setPassword(newPassword.trim());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //TODO: implements this method to find user in users with valid password
    //TODO: return User object if username and password is correct, otherwise return null
    public User login(String username, String password) {
        User user = findUserByUsername(username);
        if  (user.equals(null)) {
            return null;
        }
        if (user.validatePassword(password)) {
            return user;
        } else {
            return null;
        }
    }
}