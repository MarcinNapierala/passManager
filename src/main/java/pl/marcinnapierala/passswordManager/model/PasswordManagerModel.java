package pl.marcinnapierala.passswordManager.model;

import pl.marcinnapierala.passswordManager.user.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordManagerModel {
    private Map<String, User> userMap;
    private User currentUser;
    private String usersDirectory;

    public static final int MIN_PASS_LENGHT = 6;
    public static final String MAIN_DIRECTORY = ".." + File.separator;
    public static final String SRC_DIRECTORY = "src" + File.separator;
    public static final String VIEW_DIRECTORY = MAIN_DIRECTORY + "view" + File.separator;
    public static final String DATA_DIRECTORY = SRC_DIRECTORY + "data" + File.separator;


    public PasswordManagerModel() {
        userMap = new HashMap<String, User>();
        usersDirectory = DATA_DIRECTORY + "users.txt";
        try {
            Scanner scanner = new Scanner(new File(usersDirectory));
            String username;
            String password;
            while (scanner.hasNextLine()) {
                username = scanner.next();
                password = scanner.next();
                userMap.put(username, new User(new Account(username, password)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public String getCurrentUserName() {
        return currentUser.getAccount().getUserName();
    }

    public boolean hasUser(String username) {
        return userMap.containsKey(username);
    }

    public boolean isCorrectPassword(String username, String enteredPassword) {
        if (!hasUser(username)) return false;
        return getUser(username).getAccount().getPassword().equals(enteredPassword);
    }

    public void addUser(String username, String password) {
        try {
            File usersFile = new File(usersDirectory);
            FileWriter writer = new FileWriter(usersFile, true);
            writer.write("\n" + username + " " + password);
            writer.close();

            File userfile = new file(DATA_DIRECTORY + username + ".txt");
            userfile.createNewFile();

            userMap.put(username, new User(new Account(username, password))),
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

