package depaul.edu;

import java.util.HashMap;
import java.util.Map;

class UserManagement {
    private static Map<String, String> users = new HashMap<>();

    // Registers ew user with the provided username and password
    public static boolean register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different one.");
            return false;
        } else {
            users.put(username, password);
            System.out.println("Registration successful!");
            return true;
        }
    }

    // Logged in existing user with the provided username and password and checks username and password matches
    public static boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

