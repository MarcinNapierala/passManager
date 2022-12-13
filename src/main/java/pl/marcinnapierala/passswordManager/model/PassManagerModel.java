package pl.marcinnapierala.passswordManager.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PassManagerModel {
    private Map<String, User> userMap;
    private User currentUser;
    private String usersDirectory;

    public static final int MIN_PASS_LENGHT = 6;
    public static final String MAIN_DIRECTORY = ".." + File.separator;
    public static final String SRC_DIRECTORY = "src" + File.separator;
    public static final String VIEW_DIRECTORY = MAIN_DIRECTORY + "view" + File.separator;
    public static final String DATA_DIRECTORY = SRC_DIRECTORY + "data" + File.separator;


    public PassManagerModel() {
        userMap = new HashMap<String, User>();
        usersDirectory = DATA_DIRECTORY + "users.txt";
        try {
            Scanner scanner = new Scanner(new File(usersDirectory));
            String username;
            String password;
            while (scanner.hasNextLine())
            {
                username = scanner.next();
                password = scanner.next();
                userMap.put(username, new User(new Account(username, password)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
