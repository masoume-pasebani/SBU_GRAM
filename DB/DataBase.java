//package DB;
//
//
//import Model.Profile;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Vector;
//import java.util.concurrent.*;
//
///**
// a singleton class that intialize sever database and load from file
// **/
//public class DataBase {
//    static private final Vector<> =new Vector<>();
//    static private final Vector<Profile> accounts=new Vector<>();
//    static private final Vector<Profile> onlineAccounts=new Vector<>();
//
//    public synchronized void updateDataBase(){
//        try {
//            FileOutputStream fout = new FileOutputStream(PROFILES_FILE);
//            ObjectOutputStream objToFile = new ObjectOutputStream(fout);
//            objToFile.writeObject(ServerEXE.profiles); //writing profiles
//            objToFile.close();
//            fout.close();
//
//            fout = new FileOutputStream(MAILS_FILE);
//            objToFile = new ObjectOutputStream(fout);
//            objToFile.writeObject(ServerEXE.mails); // writing mails
//            objToFile.close();
//            fout.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void fillUsers(){
//        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get("UsersData")))) {
//            int size = objectInputStream.readInt();
//            accounts.clear();
//            for (int i = 0; i < size; i++)
//                accounts.add((Account) objectInputStream.readObject());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void writeUsers(){
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("UsersData")))){
//            objectOutputStream.writeInt(accounts.size());
//            for (Account account: accounts)
//                objectOutputStream.writeObject(account);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//}
