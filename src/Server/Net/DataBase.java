package Server.Net;

import Common.Model.Account;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;


public class DataBase {
   // public static final String FILE_PREFIX ;
    public static final String PROFILES ="C:\\Users\\fara\\IdeaProjects\\SBU GRAM\\src\\DB\\ProfilesDB";
    public static final String POSTS_FILE ="C:\\Users\\fara\\IdeaProjects\\SBU GRAM\\src\\DB\\PostsDB";


    private static DataBase ourInstance = new DataBase();

    public static DataBase getInstance() {
        return ourInstance;
    }

    private DataBase() {
    }

    @SuppressWarnings("unchecked")
    public synchronized void initializeServer() {
        try {
            FileInputStream fin = new FileInputStream(DataBase.PROFILES);
            ObjectInputStream ois = new ObjectInputStream(fin);
            Server.accountMap = new ConcurrentHashMap<>((ConcurrentHashMap<String, Account>) ois.readObject());
            ois.close();
            fin.close();
        } catch (EOFException | StreamCorruptedException e) {
            Server.accountMap = new ConcurrentHashMap<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized void updateDataBase() {
        try {
            FileOutputStream fout = new FileOutputStream(PROFILES);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(Server.accountMap);
            oos.flush();
            oos.close();
            fout.close();

//            fout = new FileOutputStream(Posts_FILE);
//            objToFile = new ObjectOutputStream(fout);
//            objToFile.writeObject(Server.postSet); // writing posts
//            objToFile.close();
//            fout.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}