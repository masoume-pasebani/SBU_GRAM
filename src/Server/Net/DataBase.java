package Server.Net;

import Common.Model.Account;
import Common.Model.Post;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.concurrent.*;

public class DataBase {
    ;
    public static final String PROFILES_FILE = "C:\\Users\\fara\\IdeaProjects\\SBU GRAM\\src\\DB\\ProfilesDB.txt";
    public static final String POSTS_FILE =  "C:\\Users\\fara\\IdeaProjects\\SBU GRAM\\src\\DB\\PostsDB.txt";


    private static DataBase ourInstance = new DataBase();

    public static DataBase getInstance() {
        return ourInstance;
    }
    private DataBase() {/* do nothing! */ }

    @SuppressWarnings("unchecked")
    public synchronized void initializeServer(){
        try {
            FileInputStream fin=new FileInputStream(DataBase.PROFILES_FILE);
            ObjectInputStream inFromFile=new ObjectInputStream(fin);
            Server.accountMap = new ConcurrentHashMap<>( (ConcurrentHashMap<String, Account>) inFromFile.readObject());
            inFromFile.close();
            fin.close();
        }
        catch(EOFException | StreamCorruptedException e){
            Server.accountMap = new ConcurrentHashMap<>();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            FileInputStream fin = new FileInputStream(DataBase.POSTS_FILE);
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


    public synchronized void updateDataBase(){
        try {
            FileOutputStream fout = new FileOutputStream(PROFILES_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(Server.accountMap); //writing profiles
            oos.flush();
            oos.close();
            fout.close();

            fout = new FileOutputStream(POSTS_FILE);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(Server.postSet);
            oos.close();
            fout.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}