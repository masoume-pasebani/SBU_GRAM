package Server.Net;

import Common.Model.Account;
import Common.Model.Post;


import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class DataBase {
    //    static private final Vector<Account> accounts=new Vector<>();
//    static private final Vector<Account> online_accounts=new Vector<>();
//    public static void fillUsers(){
//        try {
//            ObjectInputStream ois=new ObjectInputStream(Files.newInputStream(Paths.get("UsersData")));
//            int size=ois.readInt();
//            accounts.clear();
//            for (int i = 0; i < size; i++) {
//                accounts.add((Account) ois.readObject());
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void writeUsers(){
//        try {
//            ObjectOutputStream oos=new ObjectOutputStream(Files.newOutputStream(Paths.get("UsersData")));
//            oos.writeInt(accounts.size());
//            for (Account account: accounts) {
//                oos.writeObject(account);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void addAccount(Account account){
//        Objects.requireNonNull(account);
//        accounts.add(account);
//    }
////    public static Account getAccount(String username,String password) throws PasswordsDoNotMatchException, UserDoesntExistException {
////        Account account = accounts.stream().filter(a -> a.getUsername().equals(username)).findAny().orElseThrow(UserDoesntExistException::new);
////        if (!account.checkPassword(password))
////            throw new PasswordsDoNotMatchException();
////        return account;
////    }
//    public static Account getAccountForOtherUses(String username){
//        return online_accounts.stream().filter(account -> account.getUsername().equals(username)).findAny().orElse(null);
//    }
//    public static void addOnlineAccount(Account account){
//        Objects.requireNonNull(account);
//        online_accounts.add(account);
//    }
//    public static void removeAccountFromOnlineAccounts(Account account) {
//        Objects.requireNonNull(account);
//        online_accounts.remove(account);
//    }
//
//    public static boolean userExists(String username){
//        return accounts.stream().anyMatch(account -> account.getUsername().equals(username));
//    }
    public static final String FILE_PREFIX = "C:\\Users\\fara\\IdeaProjects\\SBU GRAM\\src\\Server\\DB\\";
    public static final String PROFILES_FILE = FILE_PREFIX + "ProfilesDB";
    public static final String Posts_FILE = FILE_PREFIX + "PostsDB";


    private static DataBase ourInstance = new DataBase();

    public static DataBase getInstance() {
        return ourInstance;
    }

    private DataBase() {
    }

    @SuppressWarnings("unchecked")
    public synchronized void initializeServer() {
        try {
            FileInputStream fin = new FileInputStream(DataBase.PROFILES_FILE);
            ObjectInputStream inFromFile = new ObjectInputStream(fin);
            Server.accountMap = new ConcurrentHashMap<>((ConcurrentHashMap<String, Account>) inFromFile.readObject());
            inFromFile.close();
            fin.close();
        } catch (EOFException | StreamCorruptedException e) {
            Server.accountMap = new ConcurrentHashMap<>();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fin = new FileInputStream(DataBase.Posts_FILE);
            ObjectInputStream inFromFile = new ObjectInputStream(fin);
            Server.postSet = new ConcurrentSkipListSet<>( (ConcurrentSkipListSet<Post>) inFromFile.readObject());
            inFromFile.close();
            fin.close();
        }
        catch(EOFException | StreamCorruptedException e){
            Server.postSet = new ConcurrentSkipListSet<>();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void updateDataBase() {
        try {
            FileOutputStream fout = new FileOutputStream(PROFILES_FILE);
            ObjectOutputStream objToFile = new ObjectOutputStream(fout);
            objToFile.writeObject(Server.accountMap); //writing profiles
            objToFile.close();
            fout.close();

            fout = new FileOutputStream(Posts_FILE);
            objToFile = new ObjectOutputStream(fout);
            objToFile.writeObject(Server.postSet); // writing posts
            objToFile.close();
            fout.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}