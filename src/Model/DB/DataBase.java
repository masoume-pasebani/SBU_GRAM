package Model.DB;

import Model.Account;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Vector;

public class DataBase {
    static private final Vector<Account> accounts=new Vector<>();
    static private final Vector<Account> online_accounts=new Vector<>();
    public static void fillUsers(){
        try {
            ObjectInputStream ois=new ObjectInputStream(Files.newInputStream(Paths.get("UsersData")));
            int size=ois.readInt();
            accounts.clear();
            for (int i = 0; i < size; i++) {
                accounts.add((Account) ois.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeUsers(){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(Files.newOutputStream(Paths.get("UsersData")));
            oos.writeInt(accounts.size());
            for (Account account: accounts) {
                oos.writeObject(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void addAccount(Account account){
        Objects.requireNonNull(account);
        accounts.add(account);
    }
//    public static Account getAccount(String username,String password) throws PasswordsDoNotMatchException, UserDoesntExistException {
//        Account account = accounts.stream().filter(a -> a.getUsername().equals(username)).findAny().orElseThrow(UserDoesntExistException::new);
//        if (!account.checkPassword(password))
//            throw new PasswordsDoNotMatchException();
//        return account;
//    }
    public static Account getAccountForOtherUses(String username){
        return online_accounts.stream().filter(account -> account.getUsername().equals(username)).findAny().orElse(null);
    }
    public static void addOnlineAccount(Account account){
        Objects.requireNonNull(account);
        online_accounts.add(account);
    }
    public static void removeAccountFromOnlineAccounts(Account account) {
        Objects.requireNonNull(account);
        online_accounts.remove(account);
    }

    public static boolean userExists(String username){
        return accounts.stream().anyMatch(account -> account.getUsername().equals(username));
    }

}
