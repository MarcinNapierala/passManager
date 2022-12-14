package pl.marcinnapierala.passswordManager.user;

import pl.marcinnapierala.passswordManager.model.PasswordManagerModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    private Account account;
    private HashMap<String, InternetAccount> internetAccounts;

    public User(Account account) {
        this.account = account;
        this.internetAccounts = new HashMap<String, InternetAccount>();

        try {
            Scanner scanner = new Scanner(new File(PasswordManagerModel.DATA_DIRECTORY + account.getUserName() + ".txt"));
            String domain;
            String username;
            String password;
            while (scanner.hasNextLine()) {
                domain = scanner.next();
                username = scanner.next();
                password = scanner.next();
                internetAccounts.put(domain, new InternetAcount(domain, username, password));
            }
        }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public InternetAccount getInternetAccount(String domain) {
            return internetAccounts.get(domain);
        }

        public Account getAccount() {
            return account;
        }

        public HashMap<String, InternetAccount> getInternetAccounts() {
            return internetAccounts;
        }

        public void addInternetAccount(InternetAccount internetAccount) {
            try {
                String domain = internetAccount.getDomain();
                String username = internetAccount.getUserName();
                String password = internetAccount.getPassword();
                File file = new File(PasswordManagerModel.DATA_DIRECTORY + account.getUserName() + ".txt");
                FileWriter writer = new FileWriter(file, true);
                writer.write("\n" + domain + " " + username + " " + password);
                writer.close();
                internetAccounts.put(domain, new InternetAccount(domain, username, password));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



